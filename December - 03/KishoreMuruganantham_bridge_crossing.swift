import Foundation

if var line = readLine() {
    if let range = line.range(of: "=") {
        line = String(line[range.upperBound...]).trimmingCharacters(in: .whitespaces)
    }
    line = line.replacingOccurrences(of: "[", with: "")
    line = line.replacingOccurrences(of: "]", with: "")
    let stones = line.split(separator: ",").compactMap { Int($0.trimmingCharacters(in: .whitespaces)) }
    
    var maxReach = 0
    var possible = true
    let n = stones.count
    
    for (i, jump) in stones.enumerated() {
        if i > maxReach {
            possible = false
            break
        }
        maxReach = max(maxReach, i + jump)
        if maxReach >= n - 1 {
            break
        }
    }
    print(possible ? "true" : "false")
}
