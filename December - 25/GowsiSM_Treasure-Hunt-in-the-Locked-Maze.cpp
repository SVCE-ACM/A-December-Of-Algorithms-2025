#include <iostream>
#include <string>
#include <vector>
#include <queue>
using namespace std;

struct State {
    int x, y, keys, steps;
};

int main() {
    int M, N, startX, startY;
    cin >> M >> N;

    vector<string> grid(M);
    for (int i = 0; i < M; i++) cin >> grid[i];
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            if (grid[i][j] == 'S') {
                startX = i;
                startY = j;
            }
        }
    }

    vector<vector<vector<bool>>> visited(
        M, vector<vector<bool>>(N, vector<bool>(1 << 10, false))
    );

    queue<State> q;
    q.push({startX, startY, 0, 0});
    visited[startX][startY][0] = true;

    int dx[4] = {1, -1, 0, 0}, dy[4] = {0, 0, 1, -1};

    while (!q.empty()) {
        State cur = q.front();
        q.pop();

        if (grid[cur.x][cur.y] == 'T') {
            cout << cur.steps;
            return 0;
        }

        for (int d = 0; d < 4; d++) {
            int nx = cur.x + dx[d];
            int ny = cur.y + dy[d];
            int newKeys = cur.keys;

            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

            char cell = grid[nx][ny];
            if (cell == '#') continue;

            if (cell >= 'a' && cell <= 'j') {
                newKeys |= (1 << (cell - 'a'));
            }

            if (cell >= 'A' && cell <= 'J') {
                if (!(newKeys & (1 << (cell - 'A')))) {
                    continue; 
                }
            }

            if (!visited[nx][ny][newKeys]) {
                visited[nx][ny][newKeys] = true;
                q.push({nx, ny, newKeys, cur.steps + 1});
            }
        }
    }
    cout << -1;
}
