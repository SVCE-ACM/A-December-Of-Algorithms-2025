import Foundation
var lines = [String]()
while let line = readLine() { lines.append(line) }
if !lines.isEmpty {
    let n = Int(lines[0]) ?? 0
    let m = Int(lines[1]) ?? 0
    
    struct Edge { let to: Int, w: Double }
    var adj = [[Edge]](repeating: [], count: n)
    
    if m > 0 {
        for i in 1...m {
            let parts = lines[1 + i].split(separator: " ").compactMap { Double($0) }
            let u = Int(parts[0])
            let v = Int(parts[1])
            let w = parts[2]
            adj[u].append(Edge(to: v, w: w))
        }
    }
    
    let sNodeIdx = (lines.count > 2 + m) ? Int(lines[2 + m]) ?? 0 : 0
    
    var dist = [Double](repeating: Double.infinity, count: n)
    dist[sNodeIdx] = 0
    var visited = [Bool](repeating: false, count: n)
    
    for _ in 0..<n {
        var minVal = Double.infinity
        var u = -1
        
        for i in 0..<n {
            if !visited[i] && dist[i] < minVal {
                minVal = dist[i]
                u = i
            }
        }
        
        if u == -1 { break }
        visited[u] = true
        
        for e in adj[u] {
            if dist[u] + e.w < dist[e.to] {
                dist[e.to] = dist[u] + e.w
            }
        }
    }
    
    if let res = dist.max() {
        if res == Double.infinity {
            print("-1")
        } else {
            if floor(res) == res {
                 print(Int(res))
            } else {
                 print(res)
            }
        }
    } else {
        print("-1")
    }
}
