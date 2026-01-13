#include <stdio.h>

void discoverIsland(int r, int c, int A, int B, int grid[A][B]) {
    if (grid[r][c] == 0 || r < 0 || r >= A || c < 0 || c >= B ) {
        return;
    }
    grid[r][c] = 0;
    discoverIsland(r - 1, c, A, B, grid); 
    discoverIsland(r + 1, c, A, B, grid); 
    discoverIsland(r, c - 1, A, B, grid); 
    discoverIsland(r, c + 1, A, B, grid);

}

int main() {
    int rows, columns;
    scanf("%d %d", &rows, &columns);
    int grid[rows][columns];
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            scanf("%d", &grid[i][j]);
        }
    }

    int islandCount = 0;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            if (grid[i][j] == 1) {
                islandCount++;
                discoverIsland(i, j, rows, columns, grid);
            }
        }
    }

    printf("%d", islandCount);
    return 0;
}