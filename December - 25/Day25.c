#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int r, c, keys, dist;
} State;

int main() {
    int M, N;
    scanf("%d %d", &M, &N);

    char maze[31][31];
    int sr = -1, sc = -1;

    for (int i = 0; i < M; i++) {
        scanf("%s", maze[i]);
        for (int j = 0; j < N; j++) {
            if (maze[i][j] == 'S') {
                sr = i;
                sc = j;
            }
        }
    }

    int visited[31][31][1 << 10];
    memset(visited, 0, sizeof(visited));

    State *queue = (State *)malloc(M * N * (1 << 10) * sizeof(State));
    int front = 0, rear = 0;

    queue[rear++] = (State){sr, sc, 0, 0};
    visited[sr][sc][0] = 1;

    int dr[4] = {1, -1, 0, 0};
    int dc[4] = {0, 0, 1, -1};

    while (front < rear) {
        State cur = queue[front++];

        if (maze[cur.r][cur.c] == 'T') {
            printf("%d", cur.dist);
            return 0;
        }

        for (int k = 0; k < 4; k++) {
            int nr = cur.r + dr[k];
            int nc = cur.c + dc[k];
            int nkeys = cur.keys;

            if (nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
            char cell = maze[nr][nc];
            if (cell == '#') continue;

            if (cell >= 'A' && cell <= 'J') {
                int need = cell - 'A';
                if (!(nkeys & (1 << need))) continue;
            }

            if (cell >= 'a' && cell <= 'j') {
                int got = cell - 'a';
                nkeys |= (1 << got);
            }

            if (!visited[nr][nc][nkeys]) {
                visited[nr][nc][nkeys] = 1;
                queue[rear++] = (State){nr, nc, nkeys, cur.dist + 1};
            }
        }
    }

    printf("-1");
    return 0;
}
