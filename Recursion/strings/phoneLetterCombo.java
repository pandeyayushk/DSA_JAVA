package Recursion.strings;

import java.util.ArrayList;
import java.util.List;

public class phoneLetterCombo {
    public static void main(String[] args) {
        String digits="23";
        List<String> soln=pad(digits, "");
        System.out.println(soln);
    }
    static List<String> pad(String original,String ans){
        if(original.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }
        String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ArrayList<String> soln=new ArrayList<>();
        int digit=original.charAt(0)-'0';//to convert '2' into an integer 2
        String target=map[digit];
        for(char ch:target.toCharArray()){
            soln.addAll(pad(original.substring(1),ans+ch));
        }
        return soln;
    }
}
