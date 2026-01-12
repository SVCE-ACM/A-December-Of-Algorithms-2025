#include <stdio.h>
#define N 9
int isSafe(int board[N][N], int row, int col, int num) {
    for (int i = 0; i < N; i++)
        if (board[row][i] == num || board[i][col] == num)
            return 0;
    int startRow = row - row % 3;
    int startCol = col - col % 3;
    for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++)
            if (board[startRow + i][startCol + j] == num)
                return 0;
    return 1;
}
int solveSudoku(int board[N][N]) {
    for (int row = 0; row < N; row++) {
        for (int col = 0; col < N; col++) {
            if (board[row][col] == 0) {
                for (int num = 1; num <= 9; num++) {
                    if (isSafe(board, row, col, num)) {
                        board[row][col] = num;
                        if (solveSudoku(board))
                            return 1;
                        board[row][col] = 0;
                    }
                }
                return 0;
            }
        }
    }
    return 1;
}
void printBoard(int board[N][N]) {
    printf("\nSolved Sudoku:\n");
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++)
            printf("%d ", board[i][j]);
        printf("\n");
    }
}
int main() {
    int board[N][N];
    char ch;
    printf("Enter the Sudoku (use digits 1-9 and . for empty cells):\n");
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            scanf(" %c", &ch);
            if (ch == '.')
                board[i][j] = 0;
            else
                board[i][j] = ch - '0';
        }
    }
    if (solveSudoku(board))
        printBoard(board);
    else
        printf("No solution exists\n");
    return 0;
}
