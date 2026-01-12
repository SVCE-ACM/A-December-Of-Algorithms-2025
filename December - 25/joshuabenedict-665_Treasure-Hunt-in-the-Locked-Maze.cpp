#include <bits/stdc++.h>
using namespace std;

struct State {
    int r, c, mask, steps;
};

int main() {
    int M, N;
    cin >> M >> N;
    vector<string> grid(M);
    for (int i = 0; i < M; i++) {
        cin >> grid[i];
    }
    int sr = -1, sc = -1;
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            if (grid[i][j] == 'S') {
                sr = i;
                sc = j;
            }
        }
    }
    bool visited[30][30][1 << 10] = {false};
    queue<State> q;
    q.push({sr, sc, 0, 0});
    visited[sr][sc][0] = true;
    int dr[4] = {1, -1, 0, 0};
    int dc[4] = {0, 0, 1, -1};
    while (!q.empty()) {
        State cur = q.front();
        q.pop();
        int r = cur.r, c = cur.c, mask = cur.mask, steps = cur.steps;
        if (grid[r][c] == 'T') {
            cout << steps;
            return 0;
        }
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            int newMask = mask;
            if (nr < 0 || nr >= M || nc < 0 || nc >= N)
                continue;
            char cell = grid[nr][nc];
            if (cell == '#')
                continue;
            if (cell >= 'A' && cell <= 'J') {
                int keyBit = cell - 'A';
                if ((mask & (1 << keyBit)) == 0)
                    continue; 
            }
            if (cell >= 'a' && cell <= 'j') {
                int keyBit = cell - 'a';
                newMask = mask | (1 << keyBit);
            }
            if (!visited[nr][nc][newMask]) {
                visited[nr][nc][newMask] = true;
                q.push({nr, nc, newMask, steps + 1});
            }
        }
    }
    cout << -1;
    return 0;
}
