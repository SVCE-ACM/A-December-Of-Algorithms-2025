import Foundation

var lines = [String]()
while let line = readLine() { lines.append(line) }

func extractNums(_ s: String) -> [Int] {
    let parts = s.split { !$0.isNumber }
    return parts.compactMap { Int($0) }
}

var vals = [Int]()
let digitLines = lines.filter { $0.rangeOfCharacter(from: .decimalDigits) != nil }

if digitLines.count >= 2 {
    vals = extractNums(digitLines[1])
} else if !lines.isEmpty {
    if lines.count >= 2 {
        vals = extractNums(lines[1])
    }
}

var l = 0
var r = vals.count - 1
var res = [Int]()

while l <= r {
    res.append(vals[l])
    if l != r {
        res.append(vals[r])
    }
    l += 1
    r -= 1
}
print(res.map{ String($0) }.joined(separator: " "))
