package Recursion;

import java.util.Arrays;

public class bubblesortRecursion {
    public static void main(String[] args) {
        int[] arr={2,45,2,5,20,-32,12,34};
        sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] arr, int n){
        if(n==1){
            return;
        }
        boolean swapped=false;
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
                swapped=true;
            }
        }
        if(!swapped){
                return;
        }
        sort(arr, n-1);
    } 
}
