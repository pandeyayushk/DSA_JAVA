package StacksAndQueues;

import java.util.Arrays;

public class circularQueue {
    protected int[] data;
    private int capacity;
    private int front=0,end=-1,size=0;
    private final int DEFAULT_SIZE=10;
    circularQueue(){
        this.data=new int[this.DEFAULT_SIZE];
        this.capacity=this.DEFAULT_SIZE;
    }
    circularQueue(int InitialCapacity){
        this.data=new int[InitialCapacity];
        this.capacity=InitialCapacity;
    }
    public void add(int val){
        if(size==capacity){
            int[] newData = new int[capacity * 2];
            for (int i = 0; i < size; i++) {
                newData[i] = data[(front + i) % capacity];
            }
            data = newData;
            capacity*=2;
            front=0;
            end=size-1;
        }
        end=(end+1)%capacity;
        data[end]=val;
        size++;
    }
    public int remove() throws Exception{
        if(size==0){
            throw new Exception("Can not remove from empty queue");
        }
        int removed = data[front];
        front = (front + 1) % capacity;
        size--;
        return removed;
    }
    public int peekFront() throws Exception{
        if(size==0){
            throw new Exception("Can not peek from empty queue");
        }
        return data[front];
    }
    public int getSize() {
        return size;
    }
    public int getCapacity() {
        return capacity;
    }
}
