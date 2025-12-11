import ballerina/io;
import ballerina/regex;

type Point record {
    int r;
    int c;
    int dist;
};

public function main() {
    string|error line1 = io:readln();
    if (line1 is string) {
        string[] dims = regex:split(line1, " ");
        int m = checkpanic int:fromString(dims[0]);
        int n = checkpanic int:fromString(dims[1]);
        
        int[][] grid = [];
        int i = 0;
        while (i < m) {
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
        
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) {
            io:println("-1");
            return;
        }
        
        boolean[][] visited = [];
        i = 0;
        while (i < m) {
            boolean[] vRow = [];
            int j = 0;
            while (j < n) {
                vRow.push(false);
                j = j + 1;
            }
            visited.push(vRow);
            i = i + 1;
        }
        
        Point[] queue = [];
        queue.push({r: 0, c: 0, dist: 0}); 
        
        visited[0][0] = true;
        int minSteps = -1;
        
        while (queue.length() > 0) {
            Point curr = queue.remove(0);
            if (curr.r == m - 1 && curr.c == n - 1) {
                minSteps = curr.dist;
                break;
            }
            
            int[][] dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]];
            foreach int[] d in dirs {
                int nr = curr.r + d[0];
                int nc = curr.c + d[1];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.push({r: nr, c: nc, dist: curr.dist + 1});
                }
            }
        }
        
        io:println(minSteps);
    }
}
