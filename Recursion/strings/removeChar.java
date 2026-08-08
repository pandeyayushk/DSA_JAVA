package Recursion.strings;

public class removeChar {
    public static void main(String[] args) {
        String s1="baccab";
        skip(s1, "");
        System.out.println(skip(s1));
        System.out.println(skipString("A tiger never loses sleep over the opinion of sheep.","tiger"));
        System.out.println(skipStringNotFollowed("I downloaded the app but not the apple version", "app", "apple"));
    }
    static void skip(String original,String ans){
        if(original.isEmpty()){
            System.out.println(ans);
            return;
        }
        char ch=original.charAt(0);
        if(ch=='a'){
            skip(original.substring(1), ans);
        }else{
            skip(original.substring(1), ans+ch);
        }
    }
    static String skip(String original){
        if(original.isEmpty()){
            return "";
        }
        char ch=original.charAt(0);
        if(ch=='a'){
            return skip(original.substring(1));
        }else{
            return ch+skip(original.substring(1));
        }
    }
    // Skipping a string 
    // Lets say the string to skip be "tiger"
    static String skipString(String original,String toRemove){
        if(original.isEmpty()){
            return "";
        }
        if(original.startsWith(toRemove)){
            return skipString(original.substring(toRemove.length()),toRemove);
        }else{
            return original.charAt(0)+skipString(original.substring(1),toRemove);
        }
    }

    //Now lets say we have to skip a string only when it is not followed by another string
    //for example only remove "app" not "apple"
    static String skipStringNotFollowed(String original,String toRemove,String toKeep){
        if(original.isEmpty()){
            return "";
        }
        if(original.startsWith(toRemove)&& !original.startsWith(toKeep)){
            return skipStringNotFollowed(original.substring(toRemove.length()),toRemove,toKeep);
        }else{
            return original.charAt(0)+skipStringNotFollowed(original.substring(1),toRemove,toKeep);
        }
    }
}
