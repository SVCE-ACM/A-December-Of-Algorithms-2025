/*
 * Problem: Sudoku Solver
 *
 * Approach:
 * ---------
 * Use Backtracking.
 *
 * For each empty cell:
 *  Try digits 1 → 9
 *  If valid (row + col + box rules satisfied):
 *      place digit and recurse
 *  If recursion fails:
 *      undo (backtrack)
 *
 * Guaranteed unique solution → stop when solved.
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] board = new char[9][9];

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                board[i][j] = sc.next().charAt(0);

        solve(board);

        // Print solved board
        for (char[] row : board) {
            for (char c : row)
                System.out.print(c + " ");
            System.out.println();
        }
    }

    static boolean solve(char[][] board) {

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                if (board[r][c] == '.') {

                    for (char d = '1'; d <= '9'; d++) {

                        if (isValid(board, r, c, d)) {
                            board[r][c] = d;

                            if (solve(board))
                                return true;

                            board[r][c] = '.'; // backtrack
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isValid(char[][] board, int r, int c, char d) {

        for (int i = 0; i < 9; i++) {
            if (board[r][i] == d) return false;
            if (board[i][c] == d) return false;
        }

        int sr = (r / 3) * 3;
        int sc = (c / 3) * 3;

        for (int i = sr; i < sr + 3; i++)
            for (int j = sc; j < sc + 3; j++)
                if (board[i][j] == d)
                    return false;

        return true;
    }
}
