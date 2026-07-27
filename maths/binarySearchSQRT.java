package maths;

class binarySearchSQRT {
    public static void main(String[] args) {
        System.out.println(sqrt(40,3));
    }
    //TC:-O(logn)
    static double sqrt(int number,int precision){
        int s=0;
        int e=number;
        double root=0;
        while(s<=e){
            int m=s+(e-s)/2;
            if(m*m==number){
                return m;
            }else if(m*m>number){
                e=m-1;
            }else{
                s=m+1;
                root=m;
            }
        }
        //we upgrade root in else block because its a valid candidate there only
        //if m*m>number then it cant be the root but it can be if <number
        double term=0.1;
        for (int index = 0; index < precision; index++) {
            while(root*root<number){
                root+=term;
            }
            root-=term;
            term/=10;
        }
        //for each digit after decimal we add term till the root*root<number 
        //when its bigger we know that the last value before growing b igger than the condition
        //is the candidate and will be the root with another decimal point RHS
        //so we go back to the last root and upgrade term for the next decimal point
        //and to the same till we get the required ammount of digits after decimal
        return root;
    }
}