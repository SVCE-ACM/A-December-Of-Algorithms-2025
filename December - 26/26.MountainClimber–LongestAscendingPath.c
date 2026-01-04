#include <stdio.h>
#define MAX 200
int M, N;
int grid[MAX][MAX];
int dp[MAX][MAX];
int dir[4][2] = {{-1,0},{1,0},{0,-1},{0,1}};
int dfs(int r, int c) {
    if(dp[r][c] != -1) return dp[r][c];
    int maxlen = 1;
    for(int i=0;i<4;i++) {
        int nr = r + dir[i][0];
        int nc = c + dir[i][1];
        if(nr >=0 && nr < M && nc >=0 && nc < N && grid[nr][nc] > grid[r][c]) {
            int path = 1 + dfs(nr,nc);
            if(path > maxlen) maxlen = path;
        }
    }
    dp[r][c] = maxlen;
    return maxlen;
}
int main() {
    printf("Enter number of rows and columns (M N): ");
    scanf("%d %d", &M, &N);
    printf("Enter the terrain heights (%d rows, each with %d integers):\n", M, N);
    for(int i=0;i<M;i++)
        for(int j=0;j<N;j++)
            scanf("%d", &grid[i][j]);
    for(int i=0;i<M;i++)
        for(int j=0;j<N;j++)
            dp[i][j] = -1;
    int res = 0;
    for(int i=0;i<M;i++)
        for(int j=0;j<N;j++) {
            int path = dfs(i,j);
            if(path > res) res = path;
        }
    printf("%d\n", res);
    return 0;
}
