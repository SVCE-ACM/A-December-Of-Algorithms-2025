#include <stdio.h>
//Rule 1: After placing a number, move UP and RIGHT
//Rule 2: If that position is already filled, move DOWN instead
//Rule 3: If you go out of the grid, wrap around

int main()
{
    int n;
    printf("Enter the value of n: ");
    scanf("%d", &n);
    
    int M = n * (n * n + 1) / 2;
    printf("\nMagic Constant = %d\n", M);

    if (n % 2 == 0)
    {
        printf("Magic square is only possible for odd values");
        return 0;
    }

    int magic[n][n];

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            magic[i][j] = 0;

    int row = 0;
    int col = n / 2;

    for (int num = 1; num <= n * n; num++)
    {
        magic[row][col] = num;

        int nextRow = (row - 1 + n) % n;
        int nextCol = (col + 1) % n;

        // If next cell is already filled
        if (magic[nextRow][nextCol] != 0)
        {
            row = (row + 1) % n;
        }
        else
        {
            row = nextRow;
            col = nextCol;
        }
    }

    printf("\nMagic Square:\n");
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
            printf("%3d ", magic[i][j]);
        printf("\n");
    }

    return 0;
}

