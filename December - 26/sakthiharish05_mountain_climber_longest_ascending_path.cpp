#include <iostream>
#include <vector>
#include <algorithm>

int M, N;
std::vector<std::vector<int>> grid;
std::vector<std::vector<int>> memo;

int dr[] = {-1, 1, 0, 0};
int dc[] = {0, 0, -1, 1};

int dfs(int r, int c) {
    if (memo[r][c] != 0) return memo[r][c];
    
    int max_len = 1;
    for(int i=0; i<4; ++i) {
        int nr = r + dr[i];
        int nc = c + dc[i];
        if (nr >= 0 && nr < M && nc >= 0 && nc < N && grid[nr][nc] > grid[r][c]) {
            max_len = std::max(max_len, 1 + dfs(nr, nc));
        }
    }
    
    return memo[r][c] = max_len;
}

int main() {
    if (std::cin >> M >> N) {
        grid.assign(M, std::vector<int>(N));
        memo.assign(M, std::vector<int>(N, 0));
        
        for(int i=0; i<M; ++i) {
            for(int j=0; j<N; ++j) {
                std::cin >> grid[i][j];
            }
        }
        
        int ans = 0;
        for(int i=0; i<M; ++i) {
            for(int j=0; j<N; ++j) {
                ans = std::max(ans, dfs(i, j));
            }
        }
        std::cout << ans << std::endl;
    }
    return 0;
}
