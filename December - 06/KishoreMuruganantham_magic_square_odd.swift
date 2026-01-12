import Foundation

if let line = readLine() {
    var nStr = line
    if let range = line.range(of: ":") {
        nStr = String(line[range.upperBound...]).trimmingCharacters(in: .whitespaces)
    }
    if let n = Int(nStr) {
        if n % 2 == 0 {
            print("Magic square is only possible for odd values of n.")
        } else {
            let magicConst = (n * (n * n + 1)) / 2
            print("Magic constant: \(magicConst)")
            var grid = Array(repeating: Array(repeating: 0, count: n), count: n)
            var r = 0
            var c = n / 2
            
            for num in 1...(n * n) {
                grid[r][c] = num
                var nr = r - 1
                var nc = c + 1
                if nr < 0 { nr = n - 1 }
                if nc >= n { nc = 0 }
                
                if grid[nr][nc] != 0 {
                    r = r + 1
                    if r >= n { r = 0 }
                } else {
                    r = nr
                    c = nc
                }
            }
            
            for i in 0..<n {
                print(grid[i].map{ String($0) }.joined(separator: " "))
            }
        }
    }
}
