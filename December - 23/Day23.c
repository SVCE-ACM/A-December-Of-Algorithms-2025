#include <stdio.h>

int main() {
    int m, n;
    scanf("%d %d", &m, &n);

    int grid[100][100];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &grid[i][j]);
        }
    }

    // If start or end is blocked
    if (grid[0][0] == 1 || grid[m-1][n-1] == 1) {
        printf("-1\n");
        return 0;
    }

    int visited[100][100] = {0};
    int dist[100][100];

    int qx[10000], qy[10000];
    int front = 0, rear = 0;

    // Directions: up, down, left, right
    int dx[4] = {-1, 1, 0, 0};
    int dy[4] = {0, 0, -1, 1};

    // Start BFS from (0,0)
    qx[rear] = 0;
    qy[rear] = 0;
    rear++;

    visited[0][0] = 1;
    dist[0][0] = 0;

    while (front < rear) {
        int x = qx[front];
        int y = qy[front];
        front++;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (grid[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = 1;
                    dist[nx][ny] = dist[x][y] + 1;
                    qx[rear] = nx;
                    qy[rear] = ny;
                    rear++;
                }
            }
        }
    }

    if (!visited[m-1][n-1]) {
        printf("-1\n");
    } else {
        printf("%d\n", dist[m-1][n-1]);
    }

    return 0;
}
