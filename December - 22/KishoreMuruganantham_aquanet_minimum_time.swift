import Foundation

var lines = [String]()
while let line = readLine() { lines.append(line) }
if !lines.isEmpty {
    let dims = lines[0].split(separator: " ").compactMap { Int($0) }
    let v = dims[0]
    let e = dims[1]
    
    var adj = [[Int]](repeating: [], count: v)
    if e > 0 {
        for i in 1...e {
            let edge = lines[i].split(separator: " ").compactMap { Int($0) }
            let u = edge[0]
            let w = edge[1]
            adj[u].append(w)
            adj[w].append(u)
        }
    }
    
    if lines.count > 1 + e {
        let statesLine = lines[1 + e]
        let states = statesLine.split(separator: " ").compactMap { Int($0) }
        
        var dist = [Int](repeating: -1, count: v)
        var q = [Int]()
        
        for (i, s) in states.enumerated() {
            if s == 1 {
                dist[i] = 0
                q.append(i)
            }
        }
        
        var head = 0
        var maxDist = 0
        
        while head < q.count {
            let u = q[head]
            head += 1
            let d = dist[u]
            if d > maxDist { maxDist = d }
            
            for nb in adj[u] {
                if dist[nb] == -1 {
                    dist[nb] = d + 1
                    q.append(nb)
                }
            }
        }
        
        if dist.contains(-1) {
            print("-1")
        } else {
            print(maxDist)
        }
    } else {
        // Fallback for empty states line or missing
        print("-1") 
    }
}
