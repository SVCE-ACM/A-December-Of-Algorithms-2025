import ballerina/io;
import ballerina/regex;

type State record {
    int r;
    int c;
    int mask;
    int dist;
};

public function main() {
    string|error line1 = io:readln();
    if (line1 is string) {
        string[] dims = regex:split(line1, " ");
        int m = checkpanic int:fromString(dims[0]);
        int n = checkpanic int:fromString(dims[1]);
        
        string[] grid = [];
        int startR = 0;
        int startC = 0;
        
        int i = 0;
        while (i < m) {
            string|error rowStr = io:readln();
            if (rowStr is string) {
                grid.push(rowStr);
                int idxS = rowStr.indexOf("S") ?: -1;
                if (idxS != -1) {
                    startR = i;
                    startC = idxS;
                }
            }
            i = i + 1;
        }
        
        map<boolean> visited = {};
        
        State[] queue = [];
        queue.push({r: startR, c: startC, mask: 0, dist: 0});
        visited[startR.toString() + "," + startC.toString() + ",0"] = true;
        
        int minSteps = -1;
        
        while (queue.length() > 0) {
            State curr = queue.remove(0);
            
            string cell = grid[curr.r].substring(curr.c, curr.c + 1);
            
            if (cell == "T") {
                minSteps = curr.dist;
                break;
            }
            
            int[][] dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]];
            foreach int[] d in dirs {
                int nr = curr.r + d[0];
                int nc = curr.c + d[1];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    string nextCell = grid[nr].substring(nc, nc + 1);
                    
                    if (nextCell == "#") {
                        continue;
                    }
                    
                    int newMask = curr.mask;
                    
                    int code = nextCell.toCodePointInt(0);
                    if (code >= 97 && code <= 106) { 
                        int keyBit = 1 << (code - 97);
                        newMask = newMask | keyBit;
                    }
                    
                    if (code >= 65 && code <= 74) { 
                        int doorBit = 1 << (code - 65);
                        if ((curr.mask & doorBit) == 0) {
                            continue;
                        }
                    }
                    
                    string keyStr = nr.toString() + "," + nc.toString() + "," + newMask.toString();
                    if (!visited.hasKey(keyStr)) {
                        visited[keyStr] = true;
                        queue.push({r: nr, c: nc, mask: newMask, dist: curr.dist + 1});
                    }
                }
            }
        }
        
        io:println(minSteps);
    }
}
