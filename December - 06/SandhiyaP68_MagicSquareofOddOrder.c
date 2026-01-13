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
    int num = 1;
    int i = 0, j = n / 2;
    int row, col;

    int maxNum = n * n;
    int M = (n * (maxNum + 1)) / 2;

    while (num <= maxNum) {
        magic[i][j] = num;

        row = (i - 1 + n) % n;
        col = (j + 1) % n;

        if (magic[row][col] != 0) {
            i = (i + 1) % n;
        } else {
            i = row;
            j = col;
        }

        num++;
    }

    printf("Magic constant: %d\n", M);

    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            printf("%3d ", magic[i][j]);
        }
        printf("\n");
    }

    return 0;
}
