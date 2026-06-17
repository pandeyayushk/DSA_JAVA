package Sorting;

import java.util.Arrays;
// Best Case: O(n)
// Average Case: O(n)
// Worst Case: O(n)
// Space Complexity: O(1)
// Stability: Not stable (swapping can reorder equal elements)
public class cyclicSort {
    public static void main(String[] args) {
        int[] arr={3,5,2,1,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i] != arr[correct]){
                int temp=arr[i];
                arr[i]=arr[correct];
                arr[correct]=temp;
            }else{
                i++;
            }
        }
    }
}
