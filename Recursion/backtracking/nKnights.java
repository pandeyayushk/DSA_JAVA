package Recursion.backtracking;

public class nKnights {
    public static void main(String[] args) {
        int n=3;
        boolean[][] b=new boolean[n][n];
        System.out.println(printBoardAndCount(b, 0,0,n));
    }
    static int printBoardAndCount(boolean[][] board,int sRow,int sCol,int knights){
        if(knights==0){
            display(board);
            System.out.println();
            return 1;
        }
        int count=0;
        if(sRow==board.length)return 0;
        if(sCol==board.length)return printBoardAndCount(board, sRow+1, 0, knights);
        if(isSafe(board,sRow,sCol)){
            board[sRow][sCol]=true;
            count+=printBoardAndCount(board, sRow,sCol+1,knights-1);
            board[sRow][sCol]=false;
        }
        count+=printBoardAndCount(board, sRow, sCol+1, knights);
        return count;
    }
    static void display(boolean[][] board){
        for (boolean[] bs : board) {
            for (boolean bs2 : bs) {
                if(bs2){
                    System.out.print("K");
                }else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
    static boolean isSafe(boolean[][] board,int row,int col){
        int[][] moves={{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
        for(int[] move:moves){
            int r=row+move[0];
            int c=col+move[1];
            if(r>=0&&r<board.length&&c>=0&&c<board.length){
                if(board[r][c]){
                    return false;
                }
            }
        }
        return true;
    }
}
