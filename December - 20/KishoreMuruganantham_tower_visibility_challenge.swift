import Foundation

var lines = [String]()
while let line = readLine() { lines.append(line) }
if lines.count >= 2 {
    let n = Int(lines[0]) ?? 0
    let h = lines[1].split(separator: " ").compactMap { Int($0) }
    
    var res = [Int](repeating: -1, count: n)
    var stack = [Int]()
    
    for i in stride(from: n - 1, through: 0, by: -1) {
        let val = h[i]
        while let top = stack.last, top <= val {
            stack.removeLast()
        }
        if let top = stack.last {
            res[i] = top
        } else {
            res[i] = -1
        }
        stack.append(val)
    }
    
    print(res.map{ String($0) }.joined(separator: " "))
}
