package Recursion;

public class bsRecursion {
    public static void main(String[] args) {
        int[] arr={1,3,6,8,10};
        int ans=binarysearchRecursion(arr, 6, 0, arr.length-1);
        System.out.println(ans);
    }
    //This is divide and conquer recurrence as the search space  is getting divided  by a factor
    //where as in linear recurrence it  is reduced linearly
    static int binarysearchRecursion(int arr[],int target,int s,int e){
        if(s>e){
            return -1;
        }
        int m=s+(e-s)/2;
        if(arr[m]>target){
            return binarysearchRecursion(arr, target, s, m-1);
        }else if(arr[m]<target){
            return binarysearchRecursion(arr, target, m+1, e);
        }else{
            return m;
        }
    }
}
