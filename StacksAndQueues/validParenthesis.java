package StacksAndQueues;

import java.util.Stack;

public class validParenthesis {
    public static void main(String[] args) {
        String  s="))())(";
        System.out.println(minInsertions(s));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if((!stack.isEmpty())&&(ch==')'||ch==']'||ch=='}')){
                char peek=stack.peek();
                if((ch==')' && peek=='(')||(ch==']'&&peek=='[')||(ch=='}'&& peek=='{')){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
    public int minAddToMakeValid(String s) {
        Stack<Character> stack=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch==')'){
                if(!stack.isEmpty()&&stack.peek()=='('){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }else{
                stack.push(ch);
            }
        }
        return stack.size();
    }

    public int minAddToMakeValidWithExtraPointer(String s) {
        Stack<Character> stack=new Stack<>();
        int n=s.length();
        int l=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(!stack.isEmpty()&&ch==')'){
                char peek=stack.peek();
                if(peek=='('){
                    stack.pop();
                }else{
                    l++;
                }
            }else{
                stack.push(ch);
            }
        }
        return stack.size()+l;
    }

    public static int minInsertions(String s) {
        Stack<Character> stack=new Stack<>();
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    if(i!=n-1&&s.charAt(i+1)==')'){
                        count++;
                        i++;
                    }else{
                        count+=2;
                    }
                }else{
                    if(i!=n-1&&s.charAt(i+1)==')'){
                        stack.pop();
                        i++;
                    }else{
                        count++;
                        stack.pop();
                    }
                }
            }
        }
        return count+stack.size()*2;
    }
}
