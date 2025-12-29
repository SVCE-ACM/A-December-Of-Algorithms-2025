#include <stdio.h>

int main() {
    int n;
    printf("Enter n: ");
    scanf("%d", &n);

    if (n % 2 == 0) {
        printf("Magic square is only possible for odd values of n.");
        return 0;
    }

    int magic[100][100] = {0};

    int i = n / 2;
    int j = n - 1;

    for (int num = 1; num <= n * n; num++) {
        magic[i][j] = num;

        int next_i = i - 1;
        int next_j = j + 1;

        if (next_i < 0)
            next_i = n - 1;
        if (next_j == n)
            next_j = 0;

        if (magic[next_i][next_j] != 0) {
            i = i + 1;
        } else {
            i = next_i;
            j = next_j;
        }
    }

    int magicConstant = n * (n * n + 1) / 2;
    printf("Magic constant: %d\n", magicConstant);

    for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
            printf("%4d", magic[r][c]);
        }
        printf("\n");
    }

    return 0;
}
