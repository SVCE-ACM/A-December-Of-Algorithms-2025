#include <stdio.h>

int board[9][9];

int isSafe(int row, int col, int num) {
    for (int x = 0; x < 9; x++) {
        if (board[row][x] == num) return 0;
        if (board[x][col] == num) return 0;
    }

    int startRow = row - row % 3;
    int startCol = col - col % 3;

    for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++)
            if (board[i + startRow][j + startCol] == num)
                return 0;

    return 1;
}

int solveSudoku() {
    int row, col, found = 0;

    for (row = 0; row < 9; row++) {
        for (col = 0; col < 9; col++) {
            if (board[row][col] == 0) {
                found = 1;
                goto TRY;
            }
        }
    }

TRY:
    if (!found) return 1;

    for (int num = 1; num <= 9; num++) {
        if (isSafe(row, col, num)) {
            board[row][col] = num;
            if (solveSudoku())
                return 1;
            board[row][col] = 0;
        }
    }
    return 0;
}

int main() {
    char ch;
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            scanf(" %c", &ch);
            if (ch == '.')
                board[i][j] = 0;
            else
                board[i][j] = ch - '0';
        }
    }

    solveSudoku();

    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            printf("%d ", board[i][j]);
        }
        printf("\n");
    }

    return 0;
}
