#include <stdio.h>

int grid[1000][1000];
int visited[1000][1000];
int qx[1000000], qy[1000000], qs[1000000];

int main() {
    int m, n;
    printf("Enter rows and columns: ");
    scanf("%d %d", &m, &n);

    printf("Enter the grid: ");
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &grid[i][j]);
            visited[i][j] = 0;
        }
    }

    int front = 0, rear = 0;
    if (grid[0][0] == 0) {
        qx[rear] = 0;
        qy[rear] = 0;
        qs[rear] = 0;
        rear++;
        visited[0][0] = 1;
    }

    int found = -1;
    int dx[4] = {1, -1, 0, 0};
    int dy[4] = {0, 0, 1, -1};

    while (front < rear) {
        int x = qx[front];
        int y = qy[front];
        int s = qs[front];
        front++;

        if (x == m - 1 && y == n - 1) {
            found = s;
            break;
        }

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (!visited[nx][ny] && grid[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    qx[rear] = nx;
                    qy[rear] = ny;
                    qs[rear] = s + 1;
                    rear++;
                }
            }
        }
    }

    printf("%d", found);
    return 0;
}
