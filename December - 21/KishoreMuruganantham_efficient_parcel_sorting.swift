import Foundation
var lines = [String]()
while let line = readLine() { lines.append(line) }
if lines.count >= 2 {
    let vals = lines[1].split(separator: " ").compactMap { Int($0) }
    let sortedVals = vals.sorted()
    print(sortedVals.map{ String($0) }.joined(separator: " "))
}
