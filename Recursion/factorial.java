package Recursion;

public class factorial {
    public static void main(String[] args) {
        System.out.println(func(5));
    }
    static int func(int n){
        if(n<=1){
            return 1;
        }
        return n*func(n-1);
    }
}
