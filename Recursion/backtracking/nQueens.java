package Recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class nQueens {
    //TC:-O(n^3 * n!) ->O(n!)
    //SC:-O(n^2);
    public static void main(String[] args) {
        int[][] board={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        printBoard(board, 0);
        System.out.println(printBoardinQ(board, 0));
        int n=5;
        boolean[][] b=new boolean[n][n];
        System.out.println(printBoardAndCount(b, 0));
    }
    static void printBoard(int[][] board,int sRow){
        if(sRow>=board.length){
            for (int[] is : board) {
                System.out.println(Arrays.toString(is));
            }
            System.out.println();
            return;
        }
        for(int sCol=0;sCol<board.length;sCol++){
            boolean safe=true;
            int row=sRow,col=sCol;
            for(int i=row;i>=0;i--){
                if(board[i][sCol]==1){
                    safe=false;
                    break;
                }
            }
            while (row>=0&&col<board.length) {
                if(board[row][col]==1){
                    safe=false;
                    break;
                }
                row--;
                col++;
            }
            row=sRow;
            col=sCol;
            while (col>=0&&row>=0) {
                if(board[row][col]==1){
                    safe=false;
                    break;
                }
                row--;
                col--;
            }
            if(!safe){
                continue;
            }
            board[sRow][sCol]=1;
            printBoard(board, sRow+1);
            board[sRow][sCol]=0;
        }
    }

    static List<List<String>> printBoardinQ(int[][] board,int sRow){
        if(sRow>=board.length){
            List<List<String>> ans=new ArrayList<>();
            List<String> inner=new ArrayList<>();
            for (int[] is : board) {
                String row="";
                for(int e:is){
                    if(e==1){
                        row+='Q';
                    }else{
                        row+='.';
                    }
                }
                inner.add(row);
            }
            ans.add(inner);
            return ans;
        }
        List<List<String>> soln=new ArrayList<>();
        for(int sCol=0;sCol<board.length;sCol++){
            boolean safe=true;
            int row=sRow,col=sCol;
            for(int i=row;i>=0;i--){
                if(board[i][sCol]==1){
                    safe=false;
                    break;
                }
            }
            while (row>=0&&col<board.length) {
                if(board[row][col]==1){
                    safe=false;
                    break;
                }
                row--;
                col++;
            }
            row=sRow;
            col=sCol;
            while (col>=0&&row>=0) {
                if(board[row][col]==1){
                    safe=false;
                    break;
                }
                row--;
                col--;
            }
            if(!safe){
                continue;
            }
            board[sRow][sCol]=1;
            soln.addAll(printBoardinQ(board, sRow+1));
            board[sRow][sCol]=0;
        }
        return soln;
    }

    static int printBoardAndCount(boolean[][] board,int sRow){
        if(sRow>=board.length){
            display(board);
            System.out.println();
            return 1;
        }
        int count=0;
        for(int sCol=0;sCol<board.length;sCol++){
            if(isSafe(board,sRow,sCol)){
                board[sRow][sCol]=true;
                count+=printBoardAndCount(board, sRow+1);
                board[sRow][sCol]=false;
            }
        }
        return count;
    }
    static void display(boolean[][] board){
        for (boolean[] bs : board) {
            for (boolean bs2 : bs) {
                if(bs2){
                    System.out.print("Q");
                }else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
    static boolean isSafe(boolean[][] board,int row,int col){
        for(int i=0;i<row;i++){
            if(board[i][col]){
                return false;
            }
        }
        int r=row,c=col;
        while (row>=0&&col<board.length) {
            if(board[row][col]){
                return false;
            }
            row--;
            col++;
        }       
        while (c>=0&&r>=0) {
            if(board[r][c]){
                return false;
            }
            r--;
            c--;
        }
        return true;
    }
}           



