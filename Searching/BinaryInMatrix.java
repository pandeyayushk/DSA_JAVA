import java.util.Arrays;

public class BinaryInMatrix {
    public static void main(String[] args) {
        int[][] mat ={
            {10,20,30,40},
            {11,25,35,45},
            {28,29,37,49},
            {33,34,38,50}
        };
        System.out.println(Arrays.toString(rowColSorted(mat, 37)));
    }
    //For Matrix sorteed in row wise and col wise manner
    //TC:-O(N)
    static int[] rowColSorted(int[][] mat,int target){
        int row=0;
        int col=mat[0].length-1;
        while(row<mat.length&&col>=0){
            if(mat[row][col]==target){
                return new int[]{row,col};
            }
            if(mat[row][col]>target){
                col--;
            }
            else{
                row++;
            }

        }
        return new int[]{-1,-1};
    }
}
