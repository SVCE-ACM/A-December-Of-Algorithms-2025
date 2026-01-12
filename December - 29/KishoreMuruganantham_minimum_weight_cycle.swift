import Foundation
var lines = [String]()
while let line = readLine() { lines.append(line) }
if !lines.isEmpty {
    func parse(_ l: String) -> String {
        if let r = l.range(of: "=") { return String(l[r.upperBound...]) }
        return l
    }
    
    let nStr = parse(lines[0])
    let n = Int(nStr.trimmingCharacters(in: .whitespaces)) ?? 0
    
    var adj = [[(Int, Int)]](repeating: [], count: n)
    
    if lines.count >= 2 {
        var rest = lines.dropFirst().joined(separator: " ")
        if let r = rest.range(of: "=") { rest = String(rest[r.upperBound...]) }
        rest = rest.replacingOccurrences(of: "[", with: "")
        rest = rest.replacingOccurrences(of: "]", with: "")
        rest = rest.replacingOccurrences(of: " ", with: "") // remove spaces to be safe
        let vals = rest.split(separator: ",").compactMap { Int($0) }
        
        let numEdges = vals.count / 3
        for i in 0..<numEdges {
            let u = vals[i*3]
            let v = vals[i*3+1]
            let w = vals[i*3+2]
            adj[u].append((v, w))
            adj[v].append((u, w))
        }
    }
    
    var minCycle = Int.max
    
    for s in 0..<n {
        var dist = [Int](repeating: Int.max, count: n)
        var parent = [Int](repeating: -1, count: n)
        var visited = [Bool](repeating: false, count: n)
        
        dist[s] = 0
        
        for _ in 0..<n {
            var minD = Int.max
            var u = -1
            
            for i in 0..<n {
                if !visited[i] && dist[i] < minD {
                    minD = dist[i]
                    u = i
                }
            }
            
            if u == -1 { break }
            visited[u] = true
            
            for (v, wt) in adj[u] {
                if dist[u] != Int.max {
                    if dist[u] + wt < dist[v] {
                        dist[v] = dist[u] + wt
                        parent[v] = u
                    } else if visited[v] && v != parent[u] {
                         let cycleLen = dist[u] + dist[v] + wt
                         if cycleLen < minCycle { minCycle = cycleLen }
                    }
                }
            }
        }
    }
    
    if minCycle == Int.max {
        print("-1")
    } else {
        print(minCycle)
    }
}
