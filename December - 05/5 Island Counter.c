#include <stdio.h>

int R, C;
int grid[50][50];

// Function to mark connected land as visited
void visitIsland(int i, int j) {
    // If outside grid or water, stop
    if (i < 0 || i >= R || j < 0 || j >= C || grid[i][j] == 0)
        return;

    // Mark current land as visited
    grid[i][j] = 0;

    // Visit all 4 directions
    visitIsland(i + 1, j); // down
    visitIsland(i - 1, j); // up
    visitIsland(i, j + 1); // right
    visitIsland(i, j - 1); // left
}

int main() {

    printf("Enter number of rows and columns: ");
    scanf("%d %d", &R, &C);

    printf("Enter the grid values (0 or 1):\n");
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            scanf("%d", &grid[i][j]);
        }
    }

    int islandCount = 0;

    // Traverse the grid
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {

            if (grid[i][j] == 1) {
                islandCount++;
                visitIsland(i, j);
            }
        }
    }

    printf("Number of islands: %d", islandCount);

    return 0;
}
