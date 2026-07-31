package Sorting;

import java.util.Arrays;
// Best Case: O(nlog) 
// Average Case: O(nlogn)
// Worst Case: O(n²)
// Space Complexity: In place so only by recursion calls 𝑂(log𝑛)(average),𝑂(𝑛)(worst)
// Stability: Not Stable (equal elements don't keep their relative order)
// Used over merge sort as it is inplace algorithm
public class quickSort {
    public static void main(String[] args) {
        int[] arr={5,4,2,6,7,34,34,-1};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    // QuickSort Algorithm
    // - Divide & Conquer: partition array around a pivot
    // - Recursively sort left and right partitions
    // - Pivot choice affects performance (middle/random pivot preferred not corner points)
    // - Often faster than Merge Sort in practice due to cache efficiency

    //We take a pivot and place all elements greater than it to it's RHS and less than it to it's LHS
    //Continue to do so till there is only one element in the array(base condition)
    
    static void sort(int[] arr,int low,int high){
        if(low>=high){
            return;
        }
        int s=low,e=high,mid=s+(e-s)/2,pivot=arr[mid];
        while(s<=e){
            while(arr[s]<pivot){
                s++;
            }
            while(arr[e]>pivot){
                e--;
            }
            if(s<=e){
                int temp=arr[s];
                arr[s]=arr[e];
                arr[e]=temp;
                s++;
                e--;
            }
        }
        sort(arr, low, e);
        sort(arr, s, high);
    }
}

