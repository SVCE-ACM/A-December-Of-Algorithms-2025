#include <iostream>
#include <vector>
#include <algorithm>

int m, n;
std::vector<std::vector<int>> grid;
std::vector<std::vector<int>> memo;

int dfs(int r, int c) {
    if (memo[r][c] != -1) return memo[r][c];
    
    int max_len = 1;
    int dr[] = {-1, 1, 0, 0};
    int dc[] = {0, 0, -1, 1};
    
    for (int i = 0; i < 4; ++i) {
        int nr = r + dr[i];
        int nc = c + dc[i];
        
        if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] > grid[r][c]) {
            max_len = std::max(max_len, 1 + dfs(nr, nc));
        }
    }
    
    return memo[r][c] = max_len;
}

int main() {
    if (std::cin >> m >> n) {
        grid.assign(m, std::vector<int>(n));
        memo.assign(m, std::vector<int>(n, -1));
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                std::cin >> grid[i][j];
            }
        }
        
        int longest = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                longest = std::max(longest, dfs(i, j));
            }
        }
        
        std::cout << longest << std::endl;
    }
    return 0;
}
