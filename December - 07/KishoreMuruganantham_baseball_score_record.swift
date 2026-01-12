import Foundation

if var line = readLine() {
    if let range = line.range(of: "=") {
        line = String(line[range.upperBound...]).trimmingCharacters(in: .whitespaces)
    }
    line = line.replacingOccurrences(of: "[", with: "")
    line = line.replacingOccurrences(of: "]", with: "")
    line = line.replacingOccurrences(of: "\"", with: "")
    
    let ops = line.split(separator: ",").map { String($0.trimmingCharacters(in: .whitespaces)) }
    var scores = [Int]()
    
    for op in ops {
        if op == "C" {
            if !scores.isEmpty { scores.removeLast() }
        } else if op == "D" {
            if let last = scores.last { scores.append(2 * last) }
        } else if op == "+" {
            if scores.count >= 2 {
                scores.append(scores[scores.count-1] + scores[scores.count-2])
            }
        } else {
            if let val = Int(op) { scores.append(val) }
        }
    }
    print(scores.reduce(0, +))
}
