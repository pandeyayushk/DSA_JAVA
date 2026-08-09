
package Recursion.withArrays;
import java.util.*;
public class subSet {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        List<List<Integer>> ans=subSetIteration(arr);
        for(List<Integer> s:ans){
            System.out.println(s);
        }
        int[] array={2,1,2};
        List<List<Integer>> soln=subSetIterationDuplicates(array);
        for(List<Integer> s:soln){
            System.out.println(s);
        }

    }
    static List<List<Integer>> subSetIteration(int[] arr){
        // TC:-O(N*2^N)---> At each stage we copy N elements from total subset we have at that step
        // SC:-O(N*2^N)---> size of  each subsets* number of subsets
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

    static List<List<Integer>> subSetIterationDuplicates(int[] arr){
        // TC:-O(N*2^N)---> At each stage we copy N elements from total subset we have at that step
        // SC:-O(N*2^N)---> size of  each subsets* number of subsets
        Arrays.sort(arr);
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());
        int start=0,end=0;
        for (int i=0;i<arr.length;i++) {
            if(i>0&&arr[i]==arr[i-1]){
                start=end+1;
            }
            end=outer.size()-1;
            int length=outer.size();
            for (int j = start; j < length; j++) {
                List<Integer> inner=new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }
        return outer;
    }
}
