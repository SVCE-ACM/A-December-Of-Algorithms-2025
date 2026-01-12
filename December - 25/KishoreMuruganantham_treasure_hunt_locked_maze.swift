import Foundation
var lines = [String]()
while let line = readLine() { lines.append(line) }
if !lines.isEmpty {
    let dims = lines[0].split(separator: " ").compactMap { Int($0) }
    let r = dims[0]
    let c = dims[1]
    
    var grid = [[Character]]()
    var startPos = (0, 0)
    
    for i in 1...r {
        let row = Array(lines[i])
        grid.append(row)
        if let idx = row.firstIndex(of: "S") {
            startPos = (i - 1, idx)
        }
    }
    
    func getKeyBit(_ char: Character) -> Int {
        return Int(char.asciiValue! - Character("a").asciiValue!)
    }
    func getDoorBit(_ char: Character) -> Int {
        return Int(char.asciiValue! - Character("A").asciiValue!)
    }
    
    var visited = Set<Int>() 
    
    struct State {
        let r: Int, c: Int, mask: Int, dist: Int
    }
    
    var q = [State]()
    let startState = State(r: startPos.0, c: startPos.1, mask: 0, dist: 0)
    q.append(startState)
    visited.insert((startPos.0 << 15) | (startPos.1 << 10) | 0)
    
    var head = 0
    let dr = [0, 0, 1, -1]
    let dc = [1, -1, 0, 0]
    var found = false
    
    while head < q.count {
        let curr = q[head]
        head += 1
        
        if grid[curr.r][curr.c] == "T" {
            print(curr.dist)
            found = true
            break
        }
        
        for k in 0..<4 {
            let nr = curr.r + dr[k]
            let nc = curr.c + dc[k]
            
            if nr >= 0 && nr < r && nc >= 0 && nc < c {
                let cell = grid[nr][nc]
                if cell == "#" { continue }
                
                var nmask = curr.mask
                var allowed = true
                
                if cell >= "a" && cell <= "j" {
                    nmask |= (1 << getKeyBit(cell))
                } else if cell >= "A" && cell <= "J" {
                    if (nmask & (1 << getDoorBit(cell))) == 0 {
                        allowed = false
                    }
                }
                
                if allowed {
                    let hash = (nr << 15) | (nc << 10) | nmask
                    if !visited.contains(hash) {
                        visited.insert(hash)
                        q.append(State(r: nr, c: nc, mask: nmask, dist: curr.dist + 1))
                    }
                }
            }
        }
    }
    
    if !found {
        print("-1")
    }
}
