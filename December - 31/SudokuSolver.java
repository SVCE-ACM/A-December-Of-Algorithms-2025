package Dec31;
import java.util.*;
public class SudokuSolver {

        static char[][] board = new char[9][9];

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // Read the Sudoku board
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board[i][j] = sc.next().charAt(0);
                }
            }

            solveSudoku();

            // Print solved board
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }

        static boolean solveSudoku() {
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {

                    if (board[row][col] == '.') {

                        for (char num = '1'; num <= '9'; num++) {
                            if (isValid(row, col, num)) {
                                board[row][col] = num;

                                if (solveSudoku())
                                    return true;

                                board[row][col] = '.'; // backtrack
                            }
                        }
                        return false;
                    }
                }
            }
            return true; // solved
        }

        static boolean isValid(int row, int col, char num) {

            // Check row and column
            for (int i = 0; i < 9; i++) {
                if (board[row][i] == num || board[i][col] == num)
                    return false;
            }

            // Check 3x3 box
            int startRow = (row / 3) * 3;
            int startCol = (col / 3) * 3;

            for (int i = startRow; i < startRow + 3; i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    if (board[i][j] == num)
                        return false;
                }
            }

            return true;
        }
    }


