package String_Builder;

public class sB {
    public static void main(String[] args) {
        String a="";
        for (int i = 0; i < 25; i++) {
            char ch=(char)('a'+i);
            a+=ch;
        }
        System.out.println(a);
        //To tackel the problem of immutability of string
        //If we do this in a string then 26 new objects will be created like "","a","ab","abc"... so on
        //25 of  them will be without a ref var consuming memory
        //this same operation will take O(n^2) time as the loop runs n time and everytime concatenation is creating ne obj.
        StringBuilder obj=new StringBuilder();
        for (int i = 0; i < 25; i++) {
            char ch=(char)('a'+i);
            obj.append(ch);
        }        
        System.out.println(obj);
        //With StringBuilder the change is made in the same obj 
        //No new obj is created
        //These are mutable
    }
}
