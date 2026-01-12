import Foundation

var lines = [String]()
while let line = readLine() { lines.append(line) }
if lines.count >= 2 {
    let vals = lines[1].split(separator: " ").compactMap { Int($0) }
    let totalSum = vals.reduce(0, +)
    
    var dp: Set<Int> = [0]
    
    for v in vals {
        var nextSums = [Int]()
        for s in dp {
            nextSums.append(s + v)
        }
        for ns in nextSums {
            dp.insert(ns)
        }
    }
    
    var minDiff = totalSum
    for s in dp {
        let diff = abs(totalSum - 2 * s)
        if diff < minDiff {
            minDiff = diff
        }
    }
    print(minDiff)
}
