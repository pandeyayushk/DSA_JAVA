package Recursion.backtracking;

public class maze {
    public static void main(String[] args) {
        int count=numberOfWays( 2, 2, 0, 0);
        System.out.println(count);
    }
    static int numberOfWays(int targetRow,int targetCol,int sRow,int sCol){
        if(sRow==targetRow&&sCol==targetCol){
            return 1;
        }
        int count=0;
        if(sRow<targetRow){
            count+=numberOfWays(targetRow, targetCol, sRow+1, sCol);
        }
        if(sCol<targetCol){
            count+=numberOfWays(targetRow, targetCol, sRow, sCol+1);
        }
        return count;
    }
}
