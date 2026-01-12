#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r, c;
} Node;

int main() {
    int m, n;
    scanf("%d %d", &m, &n);

    int **grid = (int **)malloc(m * sizeof(int *));
    int **dist = (int **)malloc(m * sizeof(int *));
    for (int i = 0; i < m; i++) {
        grid[i] = (int *)malloc(n * sizeof(int));
        dist[i] = (int *)malloc(n * sizeof(int));
        for (int j = 0; j < n; j++) {
            scanf("%d", &grid[i][j]);
            dist[i][j] = -1;
        }
    }

    if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
        printf("-1");
        return 0;
    }

    Node *queue = (Node *)malloc(m * n * sizeof(Node));
    int front = 0, rear = 0;

    dist[0][0] = 0;
    queue[rear++] = (Node){0, 0};

    int dr[4] = {1, -1, 0, 0};
    int dc[4] = {0, 0, 1, -1};

    while (front < rear) {
        Node cur = queue[front++];
        for (int k = 0; k < 4; k++) {
            int nr = cur.r + dr[k];
            int nc = cur.c + dc[k];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                if (grid[nr][nc] == 0 && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[cur.r][cur.c] + 1;
                    queue[rear++] = (Node){nr, nc};
                }
            }
        }
    }

    printf("%d", dist[m - 1][n - 1]);

    return 0;
}
