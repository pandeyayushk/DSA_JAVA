package Sorting;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int arr[]={1,3,2,5,8,4,5,23,4,11,0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] arr){
        boolean swapped;
        for(int i=0;i<arr.length;i++){
            swapped=false;
            for (int j = 1; j < arr.length-i; j++) {
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    swapped=true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
}

