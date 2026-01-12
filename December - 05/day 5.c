#include <stdio.h>

int R, C;
int grid[300][300];

void exploreIsland(int row, int col) {
    if (row < 0 || row >= R || col < 0 || col >= C)
        return;

    if (grid[row][col] == 0)
        return;

    grid[row][col] = 0;

    exploreIsland(row + 1, col);
    exploreIsland(row - 1, col);
    exploreIsland(row, col + 1);
    exploreIsland(row, col - 1);
}

int main() {
    scanf("%d %d", &R, &C);

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            scanf("%d", &grid[i][j]);
        }
    }

    int islandCount = 0;

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (grid[i][j] == 1) {
                islandCount++;
                exploreIsland(i, j);
            }
        }
    }

    printf("%d", islandCount);
    return 0;
}