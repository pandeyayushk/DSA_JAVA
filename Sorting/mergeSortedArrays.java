package Sorting;

public class mergeSortedArrays {
    public static void main(String[] args) {
        
    }
    //Time complexity:-O(length1+length2)
    //Space complexity:-O(length1+length2)
    static int[] merge(int[] nums1,int[] nums2, int length1,int length2 ){
        int[] ans=new int[length1+length2];
        int pointer1=0;
        int pointer2=0;
        int i=0;
        while(pointer1<length1&&pointer2<length2){
            if(nums1[pointer1]<nums2[pointer2]){
                ans[i]=nums1[pointer1];
                pointer1++;
                i++;
            }else if(nums1[pointer1]>nums2[pointer2]){
                ans[i]=nums2[pointer2];
                pointer2++;
                i++;
            }else{
                ans[i]=nums1[pointer1];
                pointer1++;
                i++;
                ans[i]=nums2[pointer2];
                pointer2++;
                i++;
            }
        }
        
        while(pointer2<length2){
            ans[i]=nums2[pointer2];
            i++;
            pointer2++;
        }
        
        while(pointer1<length1){
            ans[i]=nums1[pointer1];
            i++;
            pointer1++;
        }
        
        return ans;
    }
    
}

