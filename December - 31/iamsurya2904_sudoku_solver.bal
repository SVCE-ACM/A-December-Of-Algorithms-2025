import ballerina/io;
import ballerina/regex;

int[][] board = [];

public function main() {
    int i = 0;
    while (i < 9) {
        string|error line = io:readln();
        if (line is string) {
            string[] parts = regex:split(line, " ");
            int[] row = [];
            foreach string s in parts {
                if (s == ".") {
                    row.push(0);
                } else {
                    int|error v = int:fromString(s.trim());
                    if (v is int) { row.push(v); } else { row.push(0); }
                }
            }
            board.push(row);
        }
        i = i + 1;
    }
    
    boolean solved = solve();
    
    foreach int[] row in board {
        string s = "";
        foreach int v in row {
            s = s + v.toString() + " ";
        }
        io:println(s.trim());
    }
}

function solve() returns boolean {
    int r = -1;
    int c = -1;
    boolean emptyFound = false;
    
    int i = 0;
    while (i < 9) {
        int j = 0;
        while (j < 9) {
            if (board[i][j] == 0) {
                r = i;
                c = j;
                emptyFound = true;
                break;
            }
            j = j + 1;
        }
        if (emptyFound) { break; }
        i = i + 1;
    }
    
    if (!emptyFound) {
        return true;
    }
    
    int num = 1;
    while (num <= 9) {
        if (isValid(r, c, num)) {
            board[r][c] = num;
            if (solve()) {
                return true;
            }
            board[r][c] = 0;
        }
        num = num + 1;
    }
    
    return false;
}

function isValid(int r, int c, int num) returns boolean {
    int i = 0;
    while (i < 9) {
        if (board[r][i] == num) { return false; }
        if (board[i][c] == num) { return false; }
        i = i + 1;
    }
    
    int startR = (r / 3) * 3;
    int startC = (c / 3) * 3;
    
    i = 0;
    while (i < 3) {
        int j = 0;
        while (j < 3) {
            if (board[startR + i][startC + j] == num) { return false; }
            j = j + 1;
        }
        i = i + 1;
    }
    
    return true;
}
