#include <stdio.h>

int m, n;
int grid[205][205];
int dp[205][205];

int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};

int max(int a, int b) {
    return a > b ? a : b;
}

int dfs(int x, int y) {
    if (dp[x][y] != 0)
        return dp[x][y];

    int best = 1;

    for (int d = 0; d < 4; d++) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        if (nx >= 0 && nx < m && ny >= 0 && ny < n &&
            grid[nx][ny] > grid[x][y]) {
            best = max(best, 1 + dfs(nx, ny));
        }
    }

    dp[x][y] = best;
    return best;
}

int main() {
    scanf("%d %d", &m, &n);

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &grid[i][j]);
            dp[i][j] = 0;
        }
    }

    int result = 0;

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            result = max(result, dfs(i, j));
        }
    }

    printf("%d\n", result);
    return 0;
}
