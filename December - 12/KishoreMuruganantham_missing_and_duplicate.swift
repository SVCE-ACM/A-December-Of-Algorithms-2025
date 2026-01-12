import Foundation

var lines = [String]()
while let line = readLine() { lines.append(line) }
if lines.count >= 2 {
    let n = Int(lines[0]) ?? 0
    let arr = lines[1].split(separator: " ").compactMap { Int($0) }
    
    let sumA = arr.reduce(0, +)
    let sumSqA = arr.reduce(0) { $0 + $1 * $1 }
    
    let sumN = n * (n + 1) / 2
    let sumSqN = n * (n + 1) * (2 * n + 1) / 6
    
    let val1 = sumA - sumN
    let val2 = sumSqA - sumSqN
    
    if val1 != 0 {
        let val3 = val2 / val1
        let dup = (val1 + val3) / 2
        let missing = val3 - dup
        print("Missing Number: \(missing)")
        print("Duplicate Number: \(dup)")
    }
}
