#include <iostream>
#include <vector>
#include <queue>
#include <tuple>

int main() {
    int m, n;
    if (std::cin >> m >> n) {
        std::vector<std::vector<int>> grid(m, std::vector<int>(n));
        for(int i=0; i<m; ++i) {
            for(int j=0; j<n; ++j) {
                std::cin >> grid[i][j];
            }
        }
        
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) {
            std::cout << "-1" << std::endl;
            return 0;
        }
        
        std::queue<std::tuple<int,int,int>> q;
        q.push({0, 0, 0});
        std::vector<std::vector<bool>> visited(m, std::vector<bool>(n, false));
        visited[0][0] = true;
        
        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};
        
        while(!q.empty()) {
            auto [r, c, dist] = q.front();
            q.pop();
            
            if (r == m-1 && c == n-1) {
                std::cout << dist << std::endl;
                return 0;
            }
            
            for(int i=0; i<4; ++i) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && 
                    grid[nr][nc] == 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.push({nr, nc, dist + 1});
                }
            }
        }
        
        std::cout << "-1" << std::endl;
    }
    return 0;
}
