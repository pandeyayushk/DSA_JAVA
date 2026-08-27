package OOPS.generics;

import java.util.Arrays;


/**
 * Creating our own arraylist
 * CustomArrayList
 */
public class CustomArrayList {
    private int[] data;
    private static final int MIN_CAPACITY=10;
    private int size;
    public CustomArrayList(){
        this.data=new int[MIN_CAPACITY];
        this.size=0;
    }
    public void add(int num){
        if(size<data.length){
            data[size++]=num;
        }else{
            data=Arrays.copyOf(data,data.length*2);
            data[size++]=num;
        }
    }
    public int getSize(){
        return this.size;
    }
    public int getCapacity(){
        return data.length;
    }
    public int getElement(int index){
        return data[index];
    }
    public boolean contains(int value){
        for(int e: data){
            if(e==value){
                return true;
            }
        }
        return false;
    }
    public void showList(){
        for(int i=0;i<size;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CustomArrayList list=new CustomArrayList();
        for(int i=0;i<9;i++){
            list.add(i);
        }
        System.out.println(list.getCapacity());
        System.out.println(list.getSize());
        list.showList();
        list.add(9);
        list.add(10);
        System.out.println(list.getCapacity());
        System.out.println(list.getSize());
        list.showList();
    }
}
