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
    
    var visited = Array(repeating: Array(repeating: false, count: c), count: r)
    var count = 0
    let dr = [0, 0, 1, -1]
    let dc = [1, -1, 0, 0]
    
    for i in 0..<r {
        for j in 0..<c {
            if grid[i][j] == 1 && !visited[i][j] {
                count += 1
                var q = [(i, j)]
                visited[i][j] = true
                var head = 0
                while head < q.count {
                    let (cr, cc) = q[head]
                    head += 1
                    
                    for k in 0..<4 {
                        let nr = cr + dr[k]
                        let nc = cc + dc[k]
                        
                        if nr >= 0 && nr < r && nc >= 0 && nc < c {
                            if grid[nr][nc] == 1 && !visited[nr][nc] {
                                visited[nr][nc] = true
                                q.append((nr, nc))
                            }
                        }
                    }
                }
            }
        }
    }
    print(count)
}
