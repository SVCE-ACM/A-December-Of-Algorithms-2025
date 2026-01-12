import Foundation
if let line = readLine(), let n = Int(line) {
    var i = 1
    var squares: [Int] = []
    while i * i <= n {
        squares.append(i * i)
        i += 1
    }
    print(squares.map{ String($0) }.joined(separator: " "))
    print(squares.count)
}
