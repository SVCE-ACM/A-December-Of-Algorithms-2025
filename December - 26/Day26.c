#include <stdio.h>
#include <stdlib.h>

int M, N;
int grid[201][201];
int dp[201][201];

int dr[4] = {1, -1, 0, 0};
int dc[4] = {0, 0, 1, -1};

int max(int a, int b) {
    return a > b ? a : b;
}

int dfs(int r, int c) {
    if (dp[r][c] != 0) return dp[r][c];

    int best = 1;
    for (int k = 0; k < 4; k++) {
        int nr = r + dr[k];
        int nc = c + dc[k];
        if (nr >= 0 && nr < M && nc >= 0 && nc < N) {
            if (grid[nr][nc] > grid[r][c]) {
                best = max(best, 1 + dfs(nr, nc));
            }
        }
    }
    dp[r][c] = best;
    return best;
}

int main() {
    scanf("%d %d", &M, &N);

    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            scanf("%d", &grid[i][j]);
            dp[i][j] = 0;
        }
    }

    int ans = 0;
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            ans = max(ans, dfs(i, j));
        }
    }

    printf("%d", ans);
    return 0;
}
