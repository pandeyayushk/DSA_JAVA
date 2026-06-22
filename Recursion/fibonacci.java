package Recursion;

public class fibonacci {
    public static void main(String[] args) {
        printFibonacci(8);
    }
    static int nthFibonacci(int n){
        if (n<0){
            throw new IllegalArgumentException("n must be non-negative");
        }
        if(n<2){
            return n;
        }
        return nthFibonacci(n-1)+nthFibonacci(n-2);
    }
    static void printFibonacci(int n){
        if (n<0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        for (int i = 0; i < n; i++) {
            System.out.print(nthFibonacci(i)+" ");
        }
    }
    //Both of the above methods are non tail recursive method
    //i.e function call is not the last statement.
    //These are not very optimal
    //Space complexity of recursion is not constant as function call are stored in stack memory
    //by the order of their call and exit when the call is completed.
    //But in recursion we call function inside function so till the base case is hit all other function
    //call will be in stack memory.

    static int fiboFormula(int n){
         return (int)((Math.pow(((1+Math.sqrt(5))/2), n) - Math.pow(((1-Math.sqrt(5))/2), n))/Math.sqrt(5));
    }
    //Fibonacci formula using recurrence relation and calculating time complexity
    //we can ignore Math.pow(((1-Math.sqrt(5))/2), n))
    //as its less dominationg term
    //also use it as long only
}
