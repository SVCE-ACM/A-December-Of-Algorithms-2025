import java.util.*;
public class MonishmakerSudokuSolver {
    public static boolean solveSudoku(char[][] board){
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++ ){

                if(board[row][col]=='.'){

                    for(char num='1';num<='9';num++){
                        if(isSafe(board,row,col,num)){
                            board[row][col]=num;

                            if(solveSudoku(board))
                                return true;

                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isSafe(char[][] board,int row,int col, char num){
        for(int j=0;j<9;j++){
            if(board[row][j] == num)
                return false;
        }
        for(int i=0;i<9;i++){
            if(board[i][col]==num)
                return false;
        }

        int startRow = row - row%3;
        int startCol = col - col%3;

        for(int i=startRow;i<startRow+3;i++){
            for(int j=startCol;j<startCol+3;j++){
                if(board[i][j]==num)
                    return false;
            }
        }
        return true;
        
    }
    public static void printBoard(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        char[][] board = new char[9][9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                board[i][j] = sc.next().charAt(0);
            }
        }
        solveSudoku(board);
        printBoard(board);
    }
    
}
