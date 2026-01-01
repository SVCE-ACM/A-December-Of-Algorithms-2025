#include <stdio.h>
#include <stdbool.h>

#define N 9

// Function to print the Sudoku grid
void printGrid(char grid[N][N]) {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            printf("%c ", grid[i][j]);
        }
        printf("\n");
    }
}

// Function to check if placing 'num' at grid[row][col] is safe
bool isSafe(char grid[N][N], int row, int col, char num) {
    for (int x = 0; x < N; x++) {
        // Check row and column
        if (grid[row][x] == num || grid[x][col] == num)
            return false;
    }

    // Check 3x3 subgrid
    int startRow = row - row % 3;
    int startCol = col - col % 3;

    for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++)
            if (grid[startRow + i][startCol + j] == num)
                return false;

    return true;
}

// Recursive function to solve Sudoku
bool solveSudoku(char grid[N][N]) {
    for (int row = 0; row < N; row++) {
        for (int col = 0; col < N; col++) {
            if (grid[row][col] == '.') {
                // Try digits 1 to 9
                for (char num = '1'; num <= '9'; num++) {
                    if (isSafe(grid, row, col, num)) {
                        grid[row][col] = num;
                        if (solveSudoku(grid))
                            return true;
                        grid[row][col] = '.'; // Backtrack
                    }
                }
                return false; // If no number is valid
            }
        }
    }
    return true; // Solved
}

int main() {
    char grid[N][N];

    // Read input grid
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            scanf(" %c", &grid[i][j]);

    if (solveSudoku(grid)) {
        printGrid(grid);
    } else {
        printf("No solution exists.\n");
    }

    return 0;
}
