#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 30
#define MAX_KEYS 10
typedef struct {
    int r, c;
    int keys;   
    int steps;
} Node;
int M, N;
char maze[MAX][MAX+1];
int visited[MAX][MAX][1<<MAX_KEYS];
int directions[4][2] = {{-1,0},{1,0},{0,-1},{0,1}};
int bfs() {
    Node queue[100000];
    int front = 0, rear = 0;
    int start_r, start_c;
    for(int i=0;i<M;i++)
        for(int j=0;j<N;j++)
            if(maze[i][j] == 'S') {
                start_r = i;
                start_c = j;
            }
    queue[rear++] = (Node){start_r, start_c, 0, 0};
    visited[start_r][start_c][0] = 1;
    while(front < rear) {
        Node cur = queue[front++];
        char cell = maze[cur.r][cur.c];
        if(cell == 'T') return cur.steps;
        for(int d=0; d<4; d++) {
            int nr = cur.r + directions[d][0];
            int nc = cur.c + directions[d][1];
            int nkeys = cur.keys;
            if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
            char next_cell = maze[nr][nc];
            if(next_cell == '#') continue;
            if(next_cell >= 'a' && next_cell <= 'j')
                nkeys |= (1 << (next_cell - 'a'));
            if(next_cell >= 'A' && next_cell <= 'J') {
                if(!(cur.keys & (1 << (next_cell - 'A')))) continue;
            }
            if(!visited[nr][nc][nkeys]) {
                visited[nr][nc][nkeys] = 1;
                queue[rear++] = (Node){nr, nc, nkeys, cur.steps + 1};
            }
        }
    }
    return -1;
}
int main() {
    printf("Enter number of rows and columns (M N): ");
    scanf("%d %d", &M, &N);
    printf("Enter the maze rows (each row has %d characters):\n", N);
    for(int i=0;i<M;i++) {
        scanf("%s", maze[i]);
    }
    memset(visited, 0, sizeof(visited));
    int result = bfs();
    printf("%d\n", result);
    return 0;
}
