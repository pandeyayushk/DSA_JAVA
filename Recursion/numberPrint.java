package Recursion;

public class numberPrint {
    public static void main(String[] args) {
        printNum(5);
        reversePrint(5);
    }
    static void printNum(int n){
        if(n==0){
           return;
        }
        System.out.print(n+" ");
        printNum(n-1); 
    }
    static void reversePrint(int n){
        //To reverse print we start printing the number when the function call is being terminated
        //from the stack memory as in recursion the last fuction called will be terminated first.
        if(n==0){
            return;
        }
        //we call the n-1 method first and then print after 
        //So first from nto 0 method will me called and when base case is hit and methods start exiting 
        //from stack the printing is done
        //as we know that when a function ends it return the control to the line it was called
        reversePrint(n-1);
        System.out.print(n+" ");
    }
}
