import Foundation

if let line = readLine() {
    var s = line
    if let r = s.range(of: ":") {
        s = String(s[r.upperBound...])
    }
    if let n = Int(s.trimmingCharacters(in: .whitespaces)) {
        var count = 0
        if n > 2 {
            var isPrime = [Bool](repeating: true, count: n)
            isPrime[0] = false
            isPrime[1] = false
            for i in 2..<n {
                if isPrime[i] {
                    count += 1
                    if i * i < n {
                        var j = i * i
                        while j < n {
                            isPrime[j] = false
                            j += i
                        }
                    }
                }
            }
        }
        print("The count of prime numbers less than \(n) is: \(count)")
    }
}
