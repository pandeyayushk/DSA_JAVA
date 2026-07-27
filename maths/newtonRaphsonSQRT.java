package maths;

public class newtonRaphsonSQRT {
    public static void main(String[] args) {
        System.out.println(sqrt(40));
    }
    static double sqrt(double n){
        //we start taking guess of x to put in the formula and start calculating root with formula
        //we get the correct value of root for a number n when x is taken as root of the number n
        //in that case root=x
        //so we do the iteration of guessing x till the error i.e difference in root and x <1
        //can put more tight condition for more accurate decimal places 
        //till the condition is not met we update x=ro0t
        double x=n;
        double root;
        while(true){
            root=0.5*(x+(n/x));
            if(Math.abs(root-x)<1){
                break;
            }
            x=root;
        }
        return root;
    }
}
