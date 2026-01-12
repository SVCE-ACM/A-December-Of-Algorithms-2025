import ballerina/io;
import ballerina/regex;
import ballerina/lang.'int as ints;

int[][] matrix = [];
int[][] memo = [];
int rows = 0;
int cols = 0;

public function main() {
    string|error line1 = io:readln();
    if (line1 is string) {
        string[] dims = regex:split(line1, " ");
        rows = checkpanic int:fromString(dims[0]);
        cols = checkpanic int:fromString(dims[1]);
        
        int i = 0;
        while (i < rows) {
            string|error rowStr = io:readln();
            if (rowStr is string) {
                string[] rowNums = regex:split(rowStr, " ");
                int[] row = [];
                int[] memoRow = [];
                foreach string s in rowNums {
                    if (s != "") {
                        row.push(checkpanic int:fromString(s));
                        memoRow.push(0);
                    }
                }
                matrix.push(row);
                memo.push(memoRow);
            }
            i = i + 1;
        }
        
        int maxLen = 0;
        i = 0;
        while (i < rows) {
            int j = 0;
            while (j < cols) {
                int len = dfs(i, j);
                if (len > maxLen) {
                    maxLen = len;
                }
                j = j + 1;
            }
            i = i + 1;
        }
        
        io:println(maxLen);
    }
}

function dfs(int r, int c) returns int {
    if (memo[r][c] != 0) {
        return memo[r][c];
    }
    
    int maxPath = 1;
    int[][] dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]];
    
    foreach int[] d in dirs {
        int nr = r + d[0];
        int nc = c + d[1];
        
        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && matrix[nr][nc] > matrix[r][c]) {
            int len = 1 + dfs(nr, nc);
            if (len > maxPath) {
                maxPath = len;
            }
        }
    }
    
    memo[r][c] = maxPath;
    return maxPath;
}
