import Foundation
var lines = [String]()
while let line = readLine() { lines.append(line) }
if lines.count >= 2 {
    let n = Int(lines[0]) ?? 0
    let arr = lines[1].split(separator: " ").compactMap { Int($0) }
    
    var peaks = [Int]()
    if n >= 3 {
        for i in 1..<(n - 1) {
            if arr[i] > arr[i - 1] && arr[i] > arr[i + 1] {
                peaks.append(i)
            }
        }
    }
    
    if peaks.isEmpty {
        print("-1")
    } else {
        print(peaks.map{ String($0) }.joined(separator: " "))
    }
}
