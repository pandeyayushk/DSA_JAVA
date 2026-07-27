package maths;

public class prime {
    public static void main(String[] args) {
        boolean[] a=new boolean[41];
        sieveprime(a, 40);
    }
    static void sieveprime(boolean[] arr,int n){
        //This is called Sieve of Eratosthenes
        //Lets assume that all number in array are prime
        //starting from two we will remove all its multiple
        //continue doing this till i*i<n
        for(int i=2;i*i<=n;i++){
            //TC:-O(root n) for outer loop but its not dominationg term so 
            //overall we consider total complexity as O(nloglogn)
            if(!arr[i]){
                for(int j=i*i;j<=n;j+=i){
                    //TC:- O(N/2+n/3+....)=O(nloglogn)
                    arr[j]=true;
                }
            }
        }
        //As by default all  value of boolean array is false 
        //we assume that false means a number is prime so that we dont have to change it to true for all
        for( int i=2;i<=n;i++){
            //TC:- O(N)
            if(!arr[i]){
                System.out.print(i+" ");
            }
        }
        
    }
}
