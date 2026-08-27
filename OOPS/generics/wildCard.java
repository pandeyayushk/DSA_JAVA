package OOPS.generics;

import java.util.Arrays;
// Using wrapper classes not implementing number class will give error
// that means here T should either be number or subclasses of number class
public class wildCard <T extends Number>{
    private Object[] data;
    private static final int MIN_CAPACITY=10;
    private int size;
    public wildCard(){
        this.data=new Object[MIN_CAPACITY];
        this.size=0;
    }
    public void add(T num){
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
    @SuppressWarnings("unchecked")
    public T getElement(int index){
        return (T)(data[index]);
    }
    public boolean contains(T value){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
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
        wildCard<Integer> list=new wildCard<>();
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


