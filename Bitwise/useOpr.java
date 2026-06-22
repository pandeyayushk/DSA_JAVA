package Bitwise;

public class useOpr {
    public static void main(String[] args) {
        System.out.println(magicNum(6));
        System.out.println(noOfDigit(6, 2));
    }
    static boolean isOdd(int n){
        return (n&1)==1;
    }
    static int magicNum(int n){
        int base=5;
        int ans=0;
        while(n>0){
            int lastDigit=n&1;
            n=n>>1;
            ans+=lastDigit*base;
            base*=5;
        }
        return ans;
        //to find number of times this loops run we need to find the number of digits in bitwise of n
        //we do that in next function
    }
    static int noOfDigit(int n, int base){
        int ans=(int)(Math.log(n)/Math.log(base))+1;
        return ans;
    }

}

