import Foundation

var lines = [String]()
while let line = readLine() { lines.append(line) }
if lines.count >= 2 {
    let parts1 = lines[0].split(separator: " ").compactMap { Int($0) }
    let k = parts1.count > 1 ? parts1[1] : 0
    let nums = lines[1].split(separator: " ").compactMap { Int($0) }
    
    var currSum = 0
    var seen = [Int: Int]()
    seen[0] = -1
    var found = false
    
    for (i, num) in nums.enumerated() {
        currSum += num
        let target = currSum - k
        if let startIdx = seen[target] {
            print("\(startIdx + 1) \(i)")
            found = true
            break
        }
        if seen[currSum] == nil {
            seen[currSum] = i
        }
    }
    
    if !found {
        print("-1 -1")
    }
}
