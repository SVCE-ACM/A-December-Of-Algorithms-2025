import java.util.Scanner;

public class SudokuSolver {

    static final int SIZE = 9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] board = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }

        solveSudoku(board);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    static boolean solveSudoku(char[][] board) {

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {

                if (board[row][col] == '.') {

                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            if (solveSudoku(board)) {
                                return true;
                            }
                            board[row][col] = '.';
                        }
                    }
                    return false; 
                }
            }
        }
        return true; 
    }

    static boolean isValid(char[][] board, int row, int col, char num) {

        for (int i = 0; i < SIZE; i++) {

            if (board[row][i] == num) return false;

            if (board[i][col] == num) return false;

            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;

            if (board[boxRow][boxCol] == num) return false;
        }
        return true;
    }
}
