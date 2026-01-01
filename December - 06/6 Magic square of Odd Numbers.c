#include <stdio.h>

int main() {
    int n;

    printf("Enter n: ");
    scanf("%d", &n);

    // If n is even, magic square is not possible
    if (n % 2 == 0) {
        printf("Magic square is only possible for odd values of n.");
        return 0;
    }

    int magic[n][n];

    // Initialize all values to 0
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            magic[i][j] = 0;
        }
    }

    int i = 0;
    int j = n / 2;

    // Place numbers from 1 to n*n
    for (int num = 1; num <= n * n; num++) {
        magic[i][j] = num;

        int newi = (i - 1 + n) % n;
        int newj = (j + 1) % n;

        if (magic[newi][newj] != 0) {
            i = (i + 1) % n;
        } else {
            i = newi;
            j = newj;
        }
    }

    int magicConstant = (n * (n * n + 1)) / 2;
    printf("Magic constant: %d\n", magicConstant);

    // Print magic square
    for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
            printf("%3d ", magic[r][c]);
        }
        printf("\n");
    }

    return 0;
}
