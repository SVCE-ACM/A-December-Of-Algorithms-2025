#include <stdio.h>

int R, C;
int grid[300][300];
int visited[300][300];

// DFS to mark connected land
void dfs(int r, int c) {
    if (r < 0 || r >= R || c < 0 || c >= C)
        return;
    if (grid[r][c] == 0 || visited[r][c] == 1)
        return;

    visited[r][c] = 1;

    dfs(r + 1, c); // down
    dfs(r - 1, c); // up
    dfs(r, c + 1); // right
    dfs(r, c - 1); // left
}

int main() {
    scanf("%d %d", &R, &C);

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            scanf("%d", &grid[i][j]);
            visited[i][j] = 0;
        }
    }

    int islandCount = 0;

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (grid[i][j] == 1 && visited[i][j] == 0) {
                islandCount++;
                dfs(i, j);
            }
        }
    }

    printf("%d\n", islandCount);

    return 0;
}
