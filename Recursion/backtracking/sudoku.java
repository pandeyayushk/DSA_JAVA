package Recursion.backtracking;


public class sudoku {
    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        solver(board, 0, 0);
        
    }

    //TC:- O(9^n^2) i.e. 9 numbers are put in n^2 cells everytime
    //SC:- O(n^2) i.e. the size of the array 
    static void solver(char[][] c,int sRow,int sCol){
        if(sRow==c.length){
            display(c);
            System.out.println();
            return;
        }
        if(sCol==c[0].length){
            solver(c, sRow+1, 0);
            return;
        }
        if(c[sRow][sCol]!='.'){
            solver(c, sRow, sCol+1);
            return;
        }
        for(int e=1; e<=9; e++){
            if(isValid(c, e, sRow, sCol)){
                c[sRow][sCol] = (char)(e + '0');
                solver(c, sRow, sCol+1);
                c[sRow][sCol] = '.';
            }
        }
    }
    static void display(char[][] arr){
        for(char[] c:arr){
            for(char ch:c){
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }
    
    static boolean isValid(char[][] c,int e,int row,int col){
        //checking in full row
        for(int i=0;i<c.length;i++){
            if(c[i][col]==(char)(e+'0')){
                return false;
            }
        }
        //checking in full col
        for(int i=0;i<c.length;i++){
            if(c[row][i]==(char)(e+'0')){
                return false;
            }
        }

        //checking in 3*3 grid
        int gridRow=row%3;
        int gridCol=col%3;
        if(gridRow==0){
            if(gridCol==0){
                for(int i=row;i<row+3;i++){
                    for(int j=col;j<col+3;j++){
                        if(c[i][j]==(char)(e+'0')){
                            return false;
                        }
                    }
                }
            }
            if(gridCol==1){
                for(int i=row;i<row+3;i++){
                    for(int j=col-1;j<col+2;j++){
                        if(c[i][j]==(char)(e+'0')){
                            return false;
                        }
                    }
                }
            }
            if(gridCol==2){
                for(int i=row;i<row+3;i++){
                    for(int j=col-2;j<col+1;j++){
                        if(c[i][j]==(char)(e+'0')){
                            return false;
                        }
                    }
                }
            }
        }


        if(gridRow==1){
            if(gridCol==0){
                for(int i=row-1;i<row+2;i++){
                    for(int j=col;j<col+3;j++){
                        if(c[i][j]==(char)(e+'0')){
                            return false;
                        }
                    }
                }
            }
            if(gridCol==1){
                for(int i=row-1;i<row+2;i++){
                    for(int j=col-1;j<col+2;j++){
                        if(c[i][j]==(char)(e+'0')){
                            return false;
                        }
                    }
                }
            }
            if(gridCol==2){
                for(int i=row-1;i<row+2;i++){
                    for(int j=col-2;j<col+1;j++){
                        if(c[i][j]==(char)(e+'0')){
                            return false;
                        }
                    }
                }
            }
        }


        if(gridRow==2){
            if(gridCol==0){
                for(int i=row-2;i<row+1;i++){
                    for(int j=col;j<col+3;j++){
                        if(c[i][j]==(char)(e+'0')){
                            return false;
                        }
                    }
                }
            }
            if(gridCol==1){
                for(int i=row-2;i<row+1;i++){
                    for(int j=col-1;j<col+2;j++){
                        if(c[i][j]==(char)(e+'0')){
                            return false;
                        }
                    }
                }
            }
            if(gridCol==2){
                for(int i=row-2;i<row+1;i++){
                    for(int j=col-2;j<col+1;j++){
                        if(c[i][j]==(char)(e+'0')){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    //Another way for checking 3*3 grid and its better
    static boolean checkGrid(char[][] c,int row,int col,int e){
        row-=(row%3);
        col-=(col%3);
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(c[i][j]==(char)(e+'0')){
                    return false;
                }
            }
        }
        return true;
    }
}
