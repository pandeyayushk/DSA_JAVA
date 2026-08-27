package  exceptionHandling;

public class Main{
    static int divide(int a, int b) throws ArithmeticException {
        if(b==0){
            throw new ArithmeticException("Don't divide by zero");
        }
        return a/b;
    }
    public static void main(String[] args) {
        int a=5,b=0,c;
        try{
            c=divide(a,b);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}