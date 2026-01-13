#include <iostream>
#include <vector>

void dfs(std::vector<std::vector<int>>& grid, int r, int c, int rows, int cols) {
    if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 0) {
        return;
    }
    grid[r][c] = 0; 
    dfs(grid, r + 1, c, rows, cols);
    dfs(grid, r - 1, c, rows, cols);
    dfs(grid, r, c + 1, rows, cols);
    dfs(grid, r, c - 1, rows, cols);
}

int main() {
    int rows, cols;
    if (std::cin >> rows >> cols) {
        std::vector<std::vector<int>> grid(rows, std::vector<int>(cols));
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                std::cin >> grid[i][j];
            }
        }

        int island_count = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == 1) {
                    ++island_count;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }
        std::cout << island_count << std::endl;
    }
    return 0;
}
