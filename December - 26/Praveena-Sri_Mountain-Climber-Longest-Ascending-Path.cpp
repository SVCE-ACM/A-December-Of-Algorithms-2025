#include <bits/stdc++.h>
using namespace std;
int M, N;
vector<vector<int>> grid;
vector<vector<int>> dp;
int dr[4] = {1, -1, 0, 0};
int dc[4] = {0, 0, 1, -1};
int dfs(int r, int c) {
    if (dp[r][c] != -1)
        return dp[r][c];
    int best = 1; 
    for (int k = 0; k < 4; k++) {
        int nr = r + dr[k];
        int nc = c + dc[k];
        if (nr >= 0 && nr < M && nc >= 0 && nc < N &&
            grid[nr][nc] > grid[r][c]) {
            best = max(best, 1 + dfs(nr, nc));
        }
    }
    return dp[r][c] = best;
}

int main() {
    cin >> M >> N;
    grid.assign(M, vector<int>(N));
    dp.assign(M, vector<int>(N, -1));
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            cin >> grid[i][j];
        }
    }
    int ans = 0;
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            ans = max(ans, dfs(i, j));
        }
    }
    cout << ans;
    return 0;
}
