package StacksAndQueues;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class InBuild {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println();
        Queue<Integer> queue=new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println();
        Deque<Integer> deque=new ArrayDeque<>();
        deque.add(10);
        deque.add(20);;
        System.out.println(deque.remove());
        System.out.println(deque.removeLast());
    }
}
