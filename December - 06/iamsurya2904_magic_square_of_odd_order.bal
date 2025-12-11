import ballerina/io;

public function main() {
    string|error input = io:readln();
    if (input is string) {
        string cleanInput = input; 
        int|error n = int:fromString(cleanInput);
        if (n is error) {
             return;
        }
        
        if (n % 2 == 0) {
            io:println("Magic square is only possible for odd values of n.");
        } else {
            int magicConstant = (n * (n * n + 1)) / 2;
            io:println("Magic constant: " + magicConstant.toString());
            
            int[][] grid = [];
            int r = 0;
            while (r < n) {
                int[] row = [];
                int c = 0;
                while (c < n) {
                    row.push(0);
                    c = c + 1;
                }
                grid.push(row);
                r = r + 1;
            }
            
            int num = 1;
            int i = 0;
            int j = n / 2;
            
            while (num <= n * n) {
                grid[i][j] = num;
                num = num + 1;
                int newi = (i - 1 + n) % n;
                int newj = (j + 1) % n;
                if (grid[newi][newj] != 0) {
                    i = (i + 1) % n;
                } else {
                    i = newi;
                    j = newj;
                }
            }
            
            foreach int[] row in grid {
                string rowStr = "";
                foreach int val in row {
                    rowStr = rowStr + val.toString() + "   ";
                }
                io:println(rowStr.trim());
            }
        }
    }
}
