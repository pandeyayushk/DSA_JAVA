package Sorting;
// Best Case: O(n²)
// Average Case: O(n²)
// Worst Case: O(n²)
// Space Complexity: O(1)
//Stability: ❌ Not stable (swapping can change relative order of equal elements)
public class selectionSort {
    public static void main(String[] args) {
        
    }
    static void sortMin(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int min=i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            int temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
    }


    static void sortMax(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i > 0; i--) {
            int maxIndex = 0;
            for (int j = 1; j <= i; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
