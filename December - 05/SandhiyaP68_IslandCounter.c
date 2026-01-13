#include <stdio.h>

int R, C;
int grid[305][305];
int visited[305][305];

void dfs(int r, int c) {
    if (r < 0 || r >= R || c < 0 || c >= C)
        return;
    if (grid[r][c] == 0 || visited[r][c] == 1)
        return;

    visited[r][c] = 1;

    dfs(r + 1, c);
    dfs(r - 1, c);
    dfs(r, c + 1);
    dfs(r, c - 1);
}

int main() {
    int i, j, count = 0;

    printf("Enter number of rows and columns: ");
    scanf("%d %d", &R, &C);

    printf("Enter the grid values (0 or 1):\n");
    for (i = 0; i < R; i++) {
        for (j = 0; j < C; j++) {
            scanf("%d", &grid[i][j]);
            visited[i][j] = 0;
        }
    }

    for (i = 0; i < R; i++) {
        for (j = 0; j < C; j++) {
            if (grid[i][j] == 1 && visited[i][j] == 0) {
                dfs(i, j);
                count++;
            }
        }
    }

    printf("Number of islands: %d", count);

    return 0;
}
