package OOPS.generics;

import java.util.Arrays;


/**
 * Creating our own arraylist
 * CustomArrayList
 */
public class genericsArrayList<T> {
    private Object[] data;
    private static final int MIN_CAPACITY=10;
    private int size;
    public genericsArrayList(){
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
        genericsArrayList<Character> list=new genericsArrayList<>();
        for(int i=0;i<9;i++){
            list.add((char)('a'+i));
        }
        System.out.println(list.getCapacity());
        System.out.println(list.getSize());
        list.showList();
        list.add((char)('a'+9));
        list.add((char)('a'+10));
        System.out.println(list.getCapacity());
        System.out.println(list.getSize());
        list.showList();
        // list.add(9); shows error
    }
}
