
#include <stdio.h>

char board[9][9];

int valid(int r, int c, char ch) {
    for (int i = 0; i < 9; i++) {
        if (board[r][i] == ch) return 0;
        if (board[i][c] == ch) return 0;
        if (board[(r/3)*3 + i/3][(c/3)*3 + i%3] == ch) return 0;
    }
    return 1;
}

int solve() {
    for (int r = 0; r < 9; r++) {
        for (int c = 0; c < 9; c++) {
            if (board[r][c] == '.') {
                for (char ch = '1'; ch <= '9'; ch++) {
                    if (valid(r, c, ch)) {
                        board[r][c] = ch;
                        if (solve()) return 1;
                        board[r][c] = '.';
                    }
                }
                return 0;
            }
        }
    }
    return 1;
}

int main() {
    for (int i = 0; i < 9; i++)
        for (int j = 0; j < 9; j++)
            scanf(" %c", &board[i][j]);

    solve();

    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++)
            printf("%c ", board[i][j]);
        printf("\n");
    }
    return 0;
}
