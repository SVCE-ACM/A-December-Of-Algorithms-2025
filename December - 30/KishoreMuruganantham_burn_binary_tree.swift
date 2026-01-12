import Foundation
var lines = [String]()
while let line = readLine() { lines.append(line) }
if !lines.isEmpty {
    var vals = [String]()
    var target = 0
    
    for line in lines {
        if line.contains("root") {
            var s = line
            if let r = s.range(of: "=") { s = String(s[r.upperBound...]) }
            s = s.replacingOccurrences(of: "[", with: "")
            s = s.replacingOccurrences(of: "]", with: "")
            s = s.replacingOccurrences(of: " ", with: "")
            vals = s.split(separator: ",").map { String($0) }
        } else if line.contains("Target") {
            var s = line
            if let r = s.range(of: "=") { s = String(s[r.upperBound...]) }
            target = Int(s.trimmingCharacters(in: .whitespaces)) ?? 0
        }
    }
    
    var adj = [Int: [Int]]()
    
    if !vals.isEmpty && vals[0] != "null" {
        let rootVal = Int(vals[0])!
        var q = [rootVal]
        var head = 0
        var idx = 1
        
        while head < q.count && idx < vals.count {
            let curr = q[head]
            head += 1
            
            func addEdge(_ u: Int, _ v: Int) {
                adj[u, default: []].append(v)
                adj[v, default: []].append(u)
            }
            
            if idx < vals.count {
                let val = vals[idx]
                idx += 1
                if val != "null" {
                    let v = Int(val)!
                    addEdge(curr, v)
                    q.append(v)
                }
            }
            
            if idx < vals.count {
                let val = vals[idx]
                idx += 1
                if val != "null" {
                    let v = Int(val)!
                    addEdge(curr, v)
                    q.append(v)
                }
            }
        }
    }
    
    var visited = Set<Int>()
    var qBFS = [target]
    visited.insert(target)
    
    while !qBFS.isEmpty {
        let level = qBFS
        print(level.map{ String($0) }.joined(separator: ", "))
        
        var nextQ = [Int]()
        for u in level {
            if let nbs = adj[u] {
                for nb in nbs {
                    if !visited.contains(nb) {
                        visited.insert(nb)
                        nextQ.append(nb)
                    }
                }
            }
        }
        qBFS = nextQ
    }
}
