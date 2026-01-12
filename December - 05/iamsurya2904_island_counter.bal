import ballerina/io;
import ballerina/regex;

function dfs(int[][] grid, boolean[][] visited, int r, int c, int rows, int cols) {
    if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0 || visited[r][c]) {
        return;
    }
    visited[r][c] = true;
    dfs(grid, visited, r + 1, c, rows, cols);
    dfs(grid, visited, r - 1, c, rows, cols);
    dfs(grid, visited, r, c + 1, rows, cols);
    dfs(grid, visited, r, c - 1, rows, cols);
}

public function main() {
    string|error line1 = io:readln();
    if (line1 is string) {
        string[] dims = regex:split(line1, " ");
        int r = checkpanic int:fromString(dims[0]);
        int c = checkpanic int:fromString(dims[1]);
        
        int[][] grid = [];
        int i = 0;
        while (i < r) {
            string|error rowStr = io:readln();
            if (rowStr is string) {
                string[] rowNums = regex:split(rowStr, " ");
                int[] row = [];
                foreach string s in rowNums {
                    if (s != "") {
                        row.push(checkpanic int:fromString(s));
                    }
                }
                grid.push(row);
            }
            i = i + 1;
        }
        
        boolean[][] visited = [];
        i = 0;
        while (i < r) {
            boolean[] vRow = [];
            int j = 0;
            while (j < c) {
                vRow.push(false);
                j = j + 1;
            }
            visited.push(vRow);
            i = i + 1;
        }
        
        int islands = 0;
        i = 0;
        while (i < r) {
            int j = 0;
            while (j < c) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j, r, c);
                    islands = islands + 1;
                }
                j = j + 1;
            }
            i = i + 1;
        }
        
        io:println(islands);
    }
}
