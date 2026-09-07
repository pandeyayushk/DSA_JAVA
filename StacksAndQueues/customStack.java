package StacksAndQueues;
import java.util.Arrays;
// All operations are O(1)
public class customStack {
    protected int[] data;
    private int capacity;
    private int top=-1;
    private final int DEFAULT_SIZE=10;
    customStack(){
        this.data=new int[this.DEFAULT_SIZE];
        this.capacity=this.DEFAULT_SIZE;
    }
    customStack(int InitialCapacity){
        this.data=new int[InitialCapacity];
        this.capacity=InitialCapacity;
    }
    public void push(int val){
        if(top==capacity-1){
            data=Arrays.copyOf(data, capacity*2);
            capacity*=2;
        }
        data[++top]=val;
    }
    public int pop() throws Exception{
        if(top<0){
            throw new Exception("Can not pop from empty stack");
        }
        return data[top--];
    }
    public int peek() throws Exception{
        if(top<0){
            throw new Exception("Can not peek from empty stack");
        }
        return data[top];
    }
    public int getSize() {
        return top + 1;
    }

    public int getCapacity() {
        return capacity;
    }
    public static void main(String[] args) {
        customStack stack=new customStack(2);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.getCapacity());
        stack.push(3);
        System.out.println(stack.getCapacity());
        System.out.println(stack.getSize());
        stack.push(4);
    }
}
