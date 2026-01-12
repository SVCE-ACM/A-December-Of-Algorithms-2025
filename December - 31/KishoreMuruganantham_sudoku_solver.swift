import Foundation
var lines = [String]()
while let line = readLine() { lines.append(line) }
if lines.count >= 9 {
    var board = [[String]]()
    for i in 0..<9 {
        let row = lines[i].split(separator: " ").compactMap { String($0) }
        board.append(row)
    }
    
    func isValid(_ r: Int, _ c: Int, _ k: String) -> Bool {
        for j in 0..<9 {
            if board[r][j] == k { return false }
        }
        for i in 0..<9 {
            if board[i][c] == k { return false }
        }
        let rStart = (r / 3) * 3
        let cStart = (c / 3) * 3
        for i in 0..<3 {
            for j in 0..<3 {
                if board[rStart + i][cStart + j] == k { return false }
            }
        }
        return true
    }
    
    func solve() -> Bool {
        for i in 0..<9 {
            for j in 0..<9 {
                if board[i][j] == "." {
                    for n in 1...9 {
                        let s = String(n)
                        if isValid(i, j, s) {
                            board[i][j] = s
                            if solve() { return true }
                            board[i][j] = "."
                        }
                    }
                    return false
                }
            }
        }
        return true
    }
    
    if solve() {
        for row in board {
            print(row.joined(separator: " "))
        }
    }
}
