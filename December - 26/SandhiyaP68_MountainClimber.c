#include <stdio.h>

int m, n;
int grid[205][205];
int memo[205][205];
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};

int dfs(int x, int y) {
    if (memo[x][y] != 0) return memo[x][y];
    int best = 1;
    for (int k = 0; k < 4; k++) {
        int nx = x + dx[k];
        int ny = y + dy[k];
        if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
            if (grid[nx][ny] > grid[x][y]) {
                int len = 1 + dfs(nx, ny);
                if (len > best) best = len;
            }
        }
    }
    memo[x][y] = best;
    return best;
}

int main() {
    printf("Enter rows and columns: ");
    scanf("%d %d", &m, &n);

    printf("Enter the grid: ");
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &grid[i][j]);
            memo[i][j] = 0;
        }
    }

    int ans = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            int len = dfs(i, j);
            if (len > ans) ans = len;
        }
    }

    printf("%d", ans);
    return 0;
}
