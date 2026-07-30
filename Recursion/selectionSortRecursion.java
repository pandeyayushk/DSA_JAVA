package Recursion;

import java.util.Arrays;

public class selectionSortRecursion {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1,0,-1};
        sort(arr, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] arr,int n){
        if(n<=0){
            return;
        }
        int max=0;
        for(int i=1;i<=n;i++){
            if(arr[max]<arr[i]){
                max=i;
            }
        }
        int temp=arr[max];
        arr[max]=arr[n];
        arr[n]=temp;
        sort(arr, n-1);
    }
}
