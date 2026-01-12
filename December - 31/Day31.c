#include <stdio.h>

char board[9][9];

int isValid(int r, int c, char ch) {
    for (int i = 0; i < 9; i++) {
        if (board[r][i] == ch) return 0;
        if (board[i][c] == ch) return 0;
        int br = 3 * (r / 3) + i / 3;
        int bc = 3 * (c / 3) + i % 3;
        if (board[br][bc] == ch) return 0;
    }
    return 1;
}

int solve() {
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (board[i][j] == '.') {
                for (char ch = '1'; ch <= '9'; ch++) {
                    if (isValid(i, j, ch)) {
                        board[i][j] = ch;
                        if (solve()) return 1;
                        board[i][j] = '.';
                    }
                }
                return 0;
            }
        }
    }
    return 1;
}

int main() {
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            scanf(" %c", &board[i][j]);
        }
    }

    solve();

    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            printf("%c", board[i][j]);
            if (j < 8) printf(" ");
        }
        printf("\n");
    }
    return 0;
}
