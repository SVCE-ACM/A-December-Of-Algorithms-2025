#include <stdio.h>

int main() {
    int n, magicConstant;
    scanf("%d", &n);
    int magicSquare[10][10] = {0};
    magicConstant = n * (n * n + 1) / 2;
    if ( n % 2 == 1 ) {
        printf("Magic Constant: %d\n", magicConstant);
        int row = 0;
        int col = n / 2;
        for (int num = 1 ; num <= n * n ; num++) {
            magicSquare[row][col] = num;
            int new_row = (row - 1 + n) % n;  
            int new_col = (col - 1 + n) % n;  
            if (magicSquare[new_row][new_col] != 0) {   
                new_row = (row + 1) % n;
                new_col = col;
            }
            row = new_row;
            col = new_col;
        }
        for( int i = 0 ; i < n ; i++ ) {
            for( int j = 0 ; j < n ; j++ ) {
                printf("%d ", magicSquare[i][j]);
            }
            printf("\n");
        }
    } else {
        printf("Magic square is only possible for odd values of n.\n");
    }
    return 0;
}