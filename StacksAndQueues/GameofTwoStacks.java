package StacksAndQueues;

import java.util.LinkedList;
import java.util.List;

public class GameofTwoStacks {
    public static void main(String[] args) {
        LinkedList<Integer> a=new LinkedList<>(); 
        LinkedList<Integer> b=new LinkedList<>();
        a.push(1);
        a.push(6);
        a.push(4);
        a.push(2);
        a.push(4);
        b.push(5);
        b.push(8);
        b.push(1);
        b.push(2);
        System.out.println(a);
        System.out.println(b);

        System.out.println(twoStacks(10, a, b));
    }
    /**
     * We can't directly just remove the smallest of the two numbers(greedy approach) as the top element of
     * one stack might be big but all the elements beneath it might be small and the other stack might have the
     * top element small but the elements beneath it big and in such cases greedy won't work.
     * So, for this problem we have to consider every case(i.e all possible combinations).
     * @param maxSum
     * @param a
     * @param b
     * @return
     */
    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        return helper(maxSum,a,b,0,0);
    }
    private static int helper(int maxSum, List<Integer> a, List<Integer> b, int removed, int sum){
        if(sum>maxSum){
            return removed-1;
        }
        if(a.isEmpty()&&b.isEmpty()){
            return removed;
        }
        int stack1=0,stack2=0;

        if(!a.isEmpty()){
            int val=a.remove(0);
            stack1=helper(maxSum, a, b, removed+1, sum+val);
            a.add(0,val);
        }

        if(!b.isEmpty()){
            int val=b.remove(0);
            stack2=helper(maxSum, a, b, removed+1, sum+val);
            b.add(0,val);
        }

        return Math.max(stack1, stack2);
        
    }
}
