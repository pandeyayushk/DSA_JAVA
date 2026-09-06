package linkedlist;

import java.util.HashSet;

public class happyNumber {
    public static void main(String[] args) {
        
    }
    public static boolean isHappyMapApproach(int n) {
        int sum=n;
        HashSet<Integer> set=new HashSet<>();
        while(sum!=1){
            sum=getSum(sum);
            if(set.contains(sum)){
                return false;
            }
            set.add(sum);
        }
        return true;
    }
    static int getSum(int n){
        int sum=0;
        while(n>0){
            sum+=(n%10)*(n%10);
            n/=10;
        }
        return sum;
    }
}
