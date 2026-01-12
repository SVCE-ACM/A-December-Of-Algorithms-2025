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
    
    if grid[0][0] == 1 || grid[r-1][c-1] == 1 {
        print("-1")
    } else {
        var dist = Array(repeating: Array(repeating: -1, count: c), count: r)
        dist[0][0] = 0
        var q = [(0, 0)]
        var head = 0
        
        let dr = [0, 0, 1, -1]
        let dc = [1, -1, 0, 0]
        var found = false
        
        while head < q.count {
            let (cr, cc) = q[head]
            head += 1
            let d = dist[cr][cc]
            
            if cr == r - 1 && cc == c - 1 {
                print(d)
                found = true
                break
            }
            
            for k in 0..<4 {
                let nr = cr + dr[k]
                let nc = cc + dc[k]
                
                if nr >= 0 && nr < r && nc >= 0 && nc < c {
                    if grid[nr][nc] == 0 && dist[nr][nc] == -1 {
                        dist[nr][nc] = d + 1
                        q.append((nr, nc))
                    }
                }
            }
        }
        
        if !found {
            print("-1")
        }
    }
}
