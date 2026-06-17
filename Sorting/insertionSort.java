package Sorting;

import java.util.Arrays;
// Best Case: O(n) (already sorted, inner loop breaks quickly)
// Average Case: O(n²)
// Worst Case: O(n²)
// Space Complexity: O(1)

Stability: ✅ Stable (equal elements remain in order)
public class insertionSort {
    public static void main(String[] args) {
        int[] arr={0,-24,23,-333,223,12,2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j >0 ; j--) {
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }else{
                    break;
                }
            }
        }
    }
}
