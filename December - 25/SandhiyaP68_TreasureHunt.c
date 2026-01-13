#include <stdio.h>
#include <string.h>

char maze[35][35];
int visited[35][35][1<<10];
int qx[100000], qy[100000], qk[100000], qs[100000];

int main() {
    int m, n;
    printf("Enter rows and columns: ");
    scanf("%d %d", &m, &n);

    printf("Enter the maze: ");
    for (int i = 0; i < m; i++) {
        scanf("%s", maze[i]);
    }

    int sx, sy;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (maze[i][j] == 'S') { sx = i; sy = j; }
        }
    }

    int front = 0, rear = 0;
    qx[rear] = sx; qy[rear] = sy; qk[rear] = 0; qs[rear] = 0;
    visited[sx][sy][0] = 1;
    rear++;

    int dx[4] = {1,-1,0,0};
    int dy[4] = {0,0,1,-1};

    while (front < rear) {
        int x = qx[front];
        int y = qy[front];
        int k = qk[front];
        int s = qs[front];
        front++;

        if (maze[x][y] == 'T') {
            printf("%d", s);
            return 0;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            int nk = k;

            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            char c = maze[nx][ny];
            if (c == '#') continue;

            if (c >= 'a' && c <= 'j') {
                nk |= (1 << (c - 'a'));
            }
            if (c >= 'A' && c <= 'J') {
                if (!(nk & (1 << (c - 'A')))) continue;
            }

            if (!visited[nx][ny][nk]) {
                visited[nx][ny][nk] = 1;
                qx[rear] = nx; qy[rear] = ny; qk[rear] = nk; qs[rear] = s + 1;
                rear++;
            }
        }
    }

    printf("-1");
    return 0;
}
