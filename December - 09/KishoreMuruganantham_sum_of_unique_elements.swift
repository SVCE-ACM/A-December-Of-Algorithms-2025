import Foundation

var lines = [String]()
while let line = readLine() { lines.append(line) }
if lines.count >= 2 {
    let vals = lines[1].split(separator: " ").compactMap { Int($0) }
    var counts = [Int: Int]()
    for v in vals {
        counts[v, default: 0] += 1
    }
    let sum = counts.filter { $0.value == 1 }.map { $0.key }.reduce(0, +)
    print(sum)
}
