import Foundation
var lines = [String]()
while let line = readLine() { lines.append(line) }
if lines.count >= 2 {
    let n = Int(lines[0]) ?? 0
    if n == 0 {
        print("0")
    } else {
        let scores = lines[1].split(separator: " ").compactMap { Int($0) }
        var candies = [Int](repeating: 1, count: n)
        
        if n > 1 {
            for i in 1..<n {
                if scores[i] > scores[i - 1] {
                    candies[i] = candies[i - 1] + 1
                }
            }
            for i in stride(from: n - 2, through: 0, by: -1) {
                if scores[i] > scores[i + 1] {
                     candies[i] = max(candies[i], candies[i + 1] + 1)
                }
            }
        }
        print(candies.reduce(0, +))
    }
}
