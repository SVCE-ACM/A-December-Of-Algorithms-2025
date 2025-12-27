#include <bits/stdc++.h>
using namespace std;
int R, C;
vector<vector<int>> grid;
vector<vector<bool>> visited;
int dr[4] = {1, -1, 0, 0};
int dc[4] = {0, 0, 1, -1};
void dfs(int r, int c) {
    visited[r][c] = true;
    for (int k = 0; k < 4; k++) {
        int nr = r + dr[k];
        int nc = c + dc[k];
        if (nr >= 0 && nr < R && nc >= 0 && nc < C &&
            grid[nr][nc] == 1 && !visited[nr][nc]) {
            dfs(nr, nc);
        }
    }
}
int main() {
    cin >> R >> C;
    grid.assign(R, vector<int>(C));
    visited.assign(R, vector<bool>(C, false));
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            cin >> grid[i][j];
        }
    }
    int islands = 0;
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (grid[i][j] == 1 && !visited[i][j]) {
                islands++;
                dfs(i, j);
            }
        }
    }
    cout << islands;
    return 0;
}
