package Bitwise;

public class useOpr {
    public static void main(String[] args) {
        System.out.println(magicNum(6));
        System.out.println(noOfDigit(6, 2));
        System.out.println(powTwo(0));
        System.out.println(power(3, 6));
        System.out.println(setBits(9));
        System.out.println(xOR(9)^xOR(2));
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
        if(n == 0) return 1;
        int ans=(int)(Math.log(n)/Math.log(base))+1;
        return ans;
    }
    //to find if a number is pow of two we count the number of set bits in it.
    //if set bits = 1  then it is power of two.
    //a simple way to do this is to do n&(n-1) if its equal to 0 then n is power of 2
    static boolean powTwo(int n){
        if(n==0){
            return false;
        }
        return (n&(n-1))==0;
    }

    //Finding a pow b in time complexity of O(log(b))\
    static int power(int base, int power){
        int ans=1;
        while(power>0){
            int lastDigit=power&1;
            if(lastDigit==1){
                ans*=base;
            }
            base*=base;
            power=power>>1;
        }
        return ans;
    }
    //Finding the number of set bits in a number in time complexity of O(number of set bits).
    static int setBits(int n){
        int count=0;
        // while(n>0){
        //     n=(n&(n-1));
        //     count++;
        // }
        while(n>0){
            count++;
            n-=(n&-n);
        }
        return count;
    }

    //Finding XOR of all number from 0 to a
    //to find from range a to b just find from 0 to b and XOR the ans with oto a-1 to remove the term not neede
    //If we do this using loop it will give TLE for large numbers
    static int xOR(int a){
        if(a%4==0){
            return a;
        }
        if(a%4==1){
            return 1;
        }
        if(a%4==2){
            return a+1;
        }
        return 0;
    }
}

