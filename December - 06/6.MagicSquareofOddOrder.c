#include <stdio.h>
int main() {
    int n;
    printf("Enter n: ");
    scanf("%d", &n);
    if (n % 2 == 0) {
        printf("Magic square is only possible for odd values of n.\n");
        return 0;
    }
    int magic_square[n][n];
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            magic_square[i][j] = 0;
    int num = 1;
    int i = 0, j = n / 2;
    while (num <= n * n) {
        magic_square[i][j] = num;
        num++;
        int new_i = (i - 1 + n) % n;
        int new_j = (j + 1) % n;
        if (magic_square[new_i][new_j] != 0) {
            i = (i + 1) % n;
        } else {
            i = new_i;
            j = new_j;
        }
    }
    int M = n * (n * n + 1) / 2;
    printf("Magic constant: %d\n", M);
    for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
            printf("%3d ", magic_square[r][c]);
        }
        printf("\n");
    }
    return 0;
}
