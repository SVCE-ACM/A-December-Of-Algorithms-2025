#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);

    if (n % 2 == 0) {
        printf("Magic square is only possible for odd values of n.");
        return 0;
    }

    int magicSquare[99][99] = {0};
    int magicConstant = n * (n * n + 1) / 2;

    int row = 0;
    int col = n / 2;

    for (int num = 1; num <= n * n; num++) {
        magicSquare[row][col] = num;

        int nextRow = (row - 1 + n) % n;
        int nextCol = (col + 1) % n;

        if (magicSquare[nextRow][nextCol] != 0) {
            row = (row + 1) % n;
        } else {
            row = nextRow;
            col = nextCol;
        }
    }

    printf("Magic constant: %d\n", magicConstant);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("%4d", magicSquare[i][j]);
        }
        printf("\n");
    }

    return 0;
}
