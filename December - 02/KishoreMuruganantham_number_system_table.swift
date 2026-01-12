import Foundation

if let line = readLine(), let n = Int(line) {
    for i in 1...n {
        let bin = String(i, radix: 2)
        let s = String(format: "%5d %5o %5X %5s", i, i, i, bin)
        print(s)
    }
}
