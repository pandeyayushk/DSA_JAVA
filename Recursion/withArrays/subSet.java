
package Recursion.withArrays;
import java.util.*;
public class subSet {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        List<List<Integer>> ans=subSetIteration(arr);
        for(List<Integer> s:ans){
            System.out.println(s);
        }
    }
    static List<List<Integer>> subSetIteration(int[] arr){
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num:arr) {
            int length=outer.size();
            for (int i = 0; i < length; i++) {
                List<Integer> inner=new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }
}
