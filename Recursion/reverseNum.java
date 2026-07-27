package Recursion;

public class reverseNum {
    public static void main(String[] args) {
        System.out.println(numRev(1232));
        System.out.println(palindrome(123321));
        System.out.println(numberOfZeros(20103, 0));
    }
    static int numRev(int n){
        return helper(n, 0);
    }
    static int helper(int number,int revNum){
        if(number==0){
            return revNum;
        }
        revNum=10*revNum+number%10;
        return helper(number/10, revNum);
    }
    static boolean palindrome(int n){
        return (n==numRev(n));
    }
    static int numberOfZeros(int n,int a){
        if(n == 0 && a == 0){
            return 1;
        }
        if(n%10==n){
            return a;
        }
        if(n%10==0){
            a++;
        }
        return numberOfZeros(n/10, a);
    }
}
