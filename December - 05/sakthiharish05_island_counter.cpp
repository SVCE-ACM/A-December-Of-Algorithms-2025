#include <iostream>
#include <vector>

void dfs(std::vector<std::vector<int>>& grid, int r, int c, int R, int C) {
    if (r < 0 || r >= R || c < 0 || c >= C || grid[r][c] == 0) return;
    grid[r][c] = 0;
    dfs(grid, r+1, c, R, C);
    dfs(grid, r-1, c, R, C);
    dfs(grid, r, c+1, R, C);
    dfs(grid, r, c-1, R, C);
}

int main() {
    int R, C;
    if (std::cin >> R >> C) {
        std::vector<std::vector<int>> grid(R, std::vector<int>(C));
        for(int i=0; i<R; ++i) {
            for(int j=0; j<C; ++j) {
                std::cin >> grid[i][j];
            }
        }
        int islands = 0;
        for(int i=0; i<R; ++i) {
            for(int j=0; j<C; ++j) {
                if (grid[i][j] == 1) {
                    islands++;
                    dfs(grid, i, j, R, C);
                }
            }
        }
        std::cout << islands << std::endl;
    }
    return 0;
}
