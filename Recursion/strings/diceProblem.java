package Recursion.strings;

import java.util.ArrayList;
import java.util.List;
public class diceProblem {
    public static void main(String[] args) {
        System.out.println(diceSum("", 4,6));
    }
    static int sum(String n,int sum){
        if(n.isEmpty()){
            return sum;
        }
        int num=n.charAt(0)-'0';
        return sum(n.substring(1), sum+num);
    }
    //Face is the number of faces the dice has
    static List<String> diceSum(String processed,int target,int faces){
        if(target==0){
            List<String> list=new ArrayList<>();
            list.add(processed);
            return list;
        }
        List<String> soln=new ArrayList<>();
        for(int i=1;i<=faces&&i<=target;i++){
            soln.addAll(diceSum(processed+i,target-i,faces));
        }
        return soln;
    }
}
