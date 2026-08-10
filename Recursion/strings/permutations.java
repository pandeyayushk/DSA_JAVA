package Recursion.strings;

import java.util.ArrayList;

public class permutations {
    public static void main(String[] args) {
        allPermutation("", "abc");
        System.out.println();
        System.out.println(allPermutationRet("", "abc"));
        System.out.println(allPermutationCount("", "abc"));
        
    }
    static void allPermutation(String processed,String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.print(processed+" ");
            return;
        }
        char ch=unprocessed.charAt(0);
            for(int i=0;i<=processed.length();i++){
            String s=processed.substring(0,i);
            String e=processed.substring(i, processed.length());         
            allPermutation(s+ch+e, unprocessed.substring(1));
        }
        
    }

    static ArrayList<String> allPermutationRet(String processed,String unprocessed){

        if(unprocessed.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        ArrayList<String> ans=new ArrayList<>();
        char ch=unprocessed.charAt(0);
            for(int i=0;i<=processed.length();i++){
            String s=processed.substring(0,i);
            String e=processed.substring(i, processed.length());         
            ans.addAll(allPermutationRet(s+ch+e, unprocessed.substring(1)));
        }
        return ans;
    }

    static int allPermutationCount(String processed,String unprocessed){
        if(unprocessed.isEmpty()){
            return 1;
        } int count=0;
        char ch=unprocessed.charAt(0);
            for(int i=0;i<=processed.length();i++){
            String s=processed.substring(0,i);
            String e=processed.substring(i, processed.length());         
            count+=allPermutationCount(s+ch+e, unprocessed.substring(1));
        }
        return count;
    }
}
