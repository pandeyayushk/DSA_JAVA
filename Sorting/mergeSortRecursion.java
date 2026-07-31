package Sorting;

import java.util.Arrays;
// Best Case: O(nlog) 
// Average Case: O(nlogn)
// Worst Case: O(nlogn)
// Space Complexity: O(n)
// Stability: ✅ Stable (equal elements keep their relative order)

// At every step we brak the array in two i.e. logn
// At each step we merge n elements 
// So the time complexity is n.logn
public class mergeSortRecursion {
    public static void main(String[] args) {
        int[] arr={223,24,23,-12,3,34,2,4,22,4};
        int[] ans=sort(arr);
        System.out.println(Arrays.toString(ans));
        sortInPlace(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static int[] sort(int[] arr){
        if(arr.length<=1){
            return arr;
        }
        int[] part1=Arrays.copyOfRange(arr, 0, arr.length/2);
        int[] part2=Arrays.copyOfRange(arr, arr.length/2, arr.length);
        int[] leftsorted=sort(part1);
        int[] rightsorted=sort(part2);
        return merge(leftsorted, rightsorted, leftsorted.length, rightsorted.length);
    }
    static int[] merge(int[] nums1,int[] nums2, int length1,int length2 ){
        int[] ans=new int[length1+length2];
        int pointer1=0;
        int pointer2=0;
        int i=0;
        while(pointer1<length1&&pointer2<length2){
            if(nums1[pointer1]<nums2[pointer2]){
                ans[i++]=nums1[pointer1++];
            }else if(nums1[pointer1]>nums2[pointer2]){
                ans[i++]=nums2[pointer2++];
            }else{
                ans[i++]=nums1[pointer1++];
                ans[i++]=nums2[pointer2++];
            }
        }
        while(pointer2<length2){
            ans[i++]=nums2[pointer2++];
        }
        while(pointer1<length1){
            ans[i++]=nums1[pointer1++];
        }
        return ans;
    }
    

    static void sortInPlace(int[] arr,int s,int e){
        if(s>=e){
            return;
        }
        int m=s+(e-s)/2;
        sortInPlace(arr,s,m);
        sortInPlace(arr,m+1,e);
        mergeInPlace(arr,s,e,m);
    }
    static void mergeInPlace(int[] arr,int s, int e,int m ){
        int[] ans=new int[e-s+1];
        int pointer1=s;
        int pointer2=m+1;
        int i=0;
        while(pointer1<=m&&pointer2<=e){
            if(arr[pointer1]<arr[pointer2]){
                ans[i++]=arr[pointer1++];
            }else if(arr[pointer1]>arr[pointer2]){
                ans[i++]=arr[pointer2++];
            }else{
                ans[i++]=arr[pointer1++];
                ans[i++]=arr[pointer2++];
            }
        }
        while(pointer2<=e){
            ans[i++]=arr[pointer2++];
        }
        while(pointer1<=m){
            ans[i++]=arr[pointer1++];
        }
        
        for(int j=0;j<ans.length;j++){
            arr[s+j]=ans[j];
        }
    }
}
