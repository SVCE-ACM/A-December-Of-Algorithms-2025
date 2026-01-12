import Foundation
var lines = [String]()
while let line = readLine() { lines.append(line) }
if !lines.isEmpty {
    let dims = lines[0].split(separator: " ").compactMap { Int($0) }
    let r = dims[0]
    let c = dims[1]
    
    var grid = [[Int]]()
    for i in 1...r {
        let row = lines[i].split(separator: " ").compactMap { Int($0) }
        grid.append(row)
    }
    
    var memo = Array(repeating: Array(repeating: 0, count: c), count: r)
    let dr = [0, 0, 1, -1]
    let dc = [1, -1, 0, 0]
    
    func dfs(_ cr: Int, _ cc: Int) -> Int {
        if memo[cr][cc] != 0 { return memo[cr][cc] }
        
        var maxL = 1
        let val = grid[cr][cc]
        
        for k in 0..<4 {
            let nr = cr + dr[k]
            let nc = cc + dc[k]
            
            if nr >= 0 && nr < r && nc >= 0 && nc < c {
                if grid[nr][nc] > val {
                    let l = 1 + dfs(nr, nc)
                    if l > maxL { maxL = l }
                }
            }
        }
        memo[cr][cc] = maxL
        return maxL
    }
    
    var res = 0
    for i in 0..<r {
        for j in 0..<c {
            let tmp = dfs(i, j)
            if tmp > res { res = tmp }
        }
    }
    print(res)
}
