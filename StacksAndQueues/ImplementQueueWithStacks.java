package StacksAndQueues;

import java.util.Stack;
//Amortized O(1) Time Complexity
public class ImplementQueueWithStacks {
    public static void main(String[] args) {
        
    }
    
}

class MyQueue {

    Stack<Integer> input;
    Stack<Integer> output;
    public MyQueue(){
        input=new Stack<>();
        output=new Stack<>();
    }
    
    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        shiftStacks();
        int removed=output.pop();
        return removed;
    }

    public int peek() {
        shiftStacks();
        int peeked=output.peek();
        return peeked;
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }
    private void shiftStacks(){
        if(output.empty()){
            while(!input.empty()){
                output.push(input.pop());;
            }
        }
    }
}
