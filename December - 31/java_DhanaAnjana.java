import java.util.Scanner;

public class java_DhanaAnjana {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        char[][] board = new char[9][9];
        
        for (int i = 0; i < 9; i++) {
            String line = sc.nextLine().replace(" ", "");
            for (int j = 0; j < 9; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        
        solveSudoku(board);
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j > 0) System.out.print(" ");
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        
        sc.close();
    }
    
    static boolean solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            
                            if (solveSudoku(board)) {
                                return true;
                            }
                            
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    static boolean isValid(char[][] board, int row, int col, char c) {
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == c) {
                return false;
            }
        }
        
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) {
                return false;
            }
        }
        
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
