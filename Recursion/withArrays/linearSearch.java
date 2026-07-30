package Recursion.withArrays;

import java.util.ArrayList;

public class linearSearch {
    public static void main(String[] args) {
        int[] arr={1,3,4,5,6,7,-234,244,241,501,5};
        System.out.println(search(arr, 245, 0));
        System.out.println(searchPosition(arr, 5, 0));
        ArrayList<Integer> list =new ArrayList<>();
        System.out.println(searchAll(arr, 5, 0, list));
        System.out.println(searchAll2(arr, 5, 0));
        
    }
    static boolean search(int[] arr,int target, int index){
        if(index==arr.length){
            return false;
        }
        return arr[index]==target||search(arr, target, index+1);
    }
    static int searchPosition(int[] arr,int target, int index){
        if(index==arr.length){
            return -1;
        }
        if(arr[index]==target){
            return index;
        }
        return searchPosition(arr, target, index+1);
    }
    //for more than one target
    static ArrayList<Integer> searchAll(int[] arr, int target,int index,ArrayList<Integer> list){
        if(index==arr.length){
            return list;
        }
        if(arr[index]==target){
            list.add(index);
        }
        return searchAll(arr, target, index+1, list);
    }
    //Without passing arraylist as argument
    static ArrayList<Integer> searchAll2(int[] arr, int target,int index){
        ArrayList<Integer> list=new ArrayList<>();
        if(index==arr.length){
            return list;
        }
        if(arr[index]==target){
            list.add(index);
        }
        list.addAll(searchAll2(arr, target, index+1));
        return list;
    }

}
