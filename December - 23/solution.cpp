#include <iostream>
#include <vector>
#include <queue>

struct Point {
    int r, c;
};

int main() {
    int m, n;
    if (std::cin >> m >> n) {
        std::vector<std::vector<int>> grid(m, std::vector<int>(n));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                std::cin >> grid[i][j];
            }
        }
        
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) {
            std::cout << -1 << std::endl;
            return 0;
        }
        
        std::queue<Point> q;
        q.push({0, 0});
        
        std::vector<std::vector<int>> dist(m, std::vector<int>(n, -1));
        dist[0][0] = 0; 
        
        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};
        
        while (!q.empty()) {
            Point curr = q.front();
            q.pop();
            
            if (curr.r == m - 1 && curr.c == n - 1) {
                std::cout << dist[curr.r][curr.c] << std::endl;
                return 0;
            }
            
            for (int i = 0; i < 4; ++i) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 0 && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[curr.r][curr.c] + 1;
                    q.push({nr, nc});
                }
            }
        }
        
        std::cout << -1 << std::endl;
    }
    return 0;
}
