package StacksAndQueues;

import java.util.Arrays;

public class customQueue {
    protected int[] data;
    private int capacity;
    private int end=-1;
    private final int DEFAULT_SIZE=10;
    customQueue(){
        this.data=new int[this.DEFAULT_SIZE];
        this.capacity=this.DEFAULT_SIZE;
    }
    customQueue(int InitialCapacity){
        this.data=new int[InitialCapacity];
        this.capacity=InitialCapacity;
    }
    public void add(int val){
        if(end==capacity-1){
            data=Arrays.copyOf(data, capacity*2);
            capacity*=2;
        }
        data[++end]=val;
    }
    public int remove() throws Exception{
        if(end<0){
            throw new Exception("Can not pop from empty queue");
        }
        int removed=data[0];
        for(int i=1;i<=end;i++){
            data[i-1]=data[i];
        }
        end--;
        return removed;
    }
    public int peekFront() throws Exception{
        if(end<0){
            throw new Exception("Can not pop from empty queue");
        }
        return data[0];
    }
    
    public int getSize() {
        return end + 1;
    }

    public int getCapacity() {
        return capacity;
    }
}
