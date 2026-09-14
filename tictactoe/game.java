package tictactoe;

import java.util.Scanner;


public class game {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[][] board=new char[3][3];
        intializeBoard(board);
        boolean hasWon=false;
        char player='X';
        int row,col;
        while(!hasWon){
            printBoard(board);
            System.out.println("player "+player+" turn:");
            row=sc.nextInt();
            col=sc.nextInt();
            if(board[row][col]!=' '){
                System.out.println("Invalid move");
            }else{
                board[row][col]=player;
                hasWon=checkWinner(player,board);
                if(hasWon){
                    System.out.println("Player "+player+" has won.");
                }
                else{
                    player=(player=='X')?'O':'X';
                }
            }
        }
        sc.close();
    }
    private static boolean checkWinner(char player, char[][] board) {
        for(int r=0;r<board.length;r++){
            if(board[r][0]==player&&board[r][1]==player&&board[r][2]==player){
                return true;
            }
        }
        for(int c=0;c<board[0].length;c++){
            if(board[0][c]==player&&board[1][c]==player&&board[2][c]==player){
                return true;
            }
        }
        if(board[0][0]==player&&board[1][1]==player&&board[2][2]==player)return true;
        if(board[0][2]==player&&board[1][1]==player&&board[2][0]==player)return true;
        return false;
    }
    private static void intializeBoard(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]=' ';
            }
        }
    }
    private static void printBoard(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(j==board.length-1){
                    System.out.print(board[i][j]);
                }else{
                System.out.print(board[i][j]+" | ");
                }
            }
            System.out.println();
        }
    }
}
