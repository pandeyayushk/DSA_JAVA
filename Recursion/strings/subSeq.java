package Recursion.strings;
import java.util.List;
import java.util.ArrayList;

public class subSeq {
    public static void main(String[] args) {
        subSequence("abc", "");
        ArrayList<String> soln=subSequenceRet("abc", "");
        System.out.println(soln);
        subSequenceAsci("abc","");
        System.out.println(subSequenceAsciRet("abc", ""));
        List<List<String>> ans=subSeqIteration("abc");
        for(List<String> s:ans){
            System.out.println(s);
        }
    }
    static void subSequence(String original,String ans){
        if(original.isEmpty()){
            System.out.print(ans+" ");
            return;
        }
        char ch=original.charAt(0);
        subSequence(original.substring(1), ans+ch);
        subSequence(original.substring(1), ans);
    }
    static ArrayList<String> subSequenceRet(String original,String ans){
        ArrayList<String> list=new ArrayList<>();
        if(original.isEmpty()){
            list.add(ans);
            return list;
        }
        char ch=original.charAt(0);
        ArrayList<String> left=subSequenceRet(original.substring(1),ans+ch);
        ArrayList<String> right=subSequenceRet(original.substring(1),ans);
        list.addAll(left);
        list.addAll(right);
        return list;
    }
    //To get asi value of char c:- (c+0);
    static void subSequenceAsci(String original,String ans){
        if(original.isEmpty()){
            System.out.print(ans+" ");
            return;
        }
        char ch=original.charAt(0);
        subSequenceAsci(original.substring(1), ans+ch);
        subSequenceAsci(original.substring(1), ans+(ch+0));
        subSequenceAsci(original.substring(1), ans);
    }

    static ArrayList<String> subSequenceAsciRet(String original,String ans){
        ArrayList<String> list=new ArrayList<>();
        if(original.isEmpty()){
            list.add(ans);
            return list;
        }
        char ch=original.charAt(0);
        ArrayList<String> left=subSequenceAsciRet(original.substring(1),ans+ch);
        ArrayList<String> right=subSequenceAsciRet(original.substring(1),ans);
        ArrayList<String> asci=subSequenceAsciRet(original.substring(1),ans+(ch+0));
        list.addAll(left);
        list.addAll(right);
        list.addAll(asci);
        return list;
    }

    static List<List<String>> subSeqIteration(String arr){
        List<List<String>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int i=0;i<arr.length();i++) {
            int length=outer.size();
            for (int j = 0; j < length; j++) {
                List<String> inner=new ArrayList<>(outer.get(j));
                inner.add(String.valueOf(arr.charAt(i)));
                outer.add(inner);
            }
        }
        return outer;
    }
}
