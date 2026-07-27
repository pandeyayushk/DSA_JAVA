package Recursion.withArrays;

public class checkSorted {
    public static void main(String[] args) {
        int[] arr={1,22,33,55,73,-23};
        System.out.println(cS(arr, 0));
    }
    // To check if an array is sorted or not  
    // Start a pointer from 0 annd check if element at that position is less or  equal to
    // element at next position. If true then movve the pointer one step ahead.
    // If the pointer reaches the last index then it the base condition and array is sorted.
    static boolean cS(int[] arr,int start){
        if(start==arr.length-1){
            return true;
        }
        if(arr[start]>arr[start+1]){
            return false;
        }
        return cS(arr, start+1);
    } 
}
