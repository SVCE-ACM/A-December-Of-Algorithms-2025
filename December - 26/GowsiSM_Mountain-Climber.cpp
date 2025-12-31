#include <vector>
#include <iostream>
using namespace std;

int M, N;
vector<vector<int>> grid;
vector<vector<int>> dp;

int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};

int dfs(int x, int y) {
    if (dp[x][y] != 0) return dp[x][y];

    int best = 1; 

    for (int d = 0; d < 4; d++) {
        int nx = x + dx[d], ny = y + dy[d];

        if (nx >= 0 && ny >= 0 && nx < M && ny < N &&
          grid[nx][ny] > grid[x][y]) {
               best = max(best, 1 + dfs(nx, ny));
          }
    }
    dp[x][y] = best;
    return best;
}

int main() {
    cin >> M >> N;
    grid.resize(M, vector<int>(N));
    dp.resize(M, vector<int>(N, 0));

    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            cin >> grid[i][j];
        }
    }

    int answer = 0;
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            answer = max(answer, dfs(i, j));
        }
    }
    cout << answer;
}
