import Foundation

var lines = [String]()
while let line = readLine() { lines.append(line) }
if lines.count >= 2 {
    func parse(_ l: String) -> [Int] {
        var s = l
        if let r = s.range(of: "=") {
            s = String(s[r.upperBound...])
        }
        s = s.replacingOccurrences(of: "[", with: "")
        s = s.replacingOccurrences(of: "]", with: "")
        return s.split(separator: ",").compactMap { Int($0.trimmingCharacters(in: .whitespaces)) }
    }
    
    let students = parse(lines[0])
    let sandwiches = parse(lines[1])
    
    var count0 = students.filter{ $0 == 0 }.count
    var count1 = students.filter{ $0 == 1 }.count
    
    for s in sandwiches {
        if s == 0 {
            if count0 > 0 { count0 -= 1 } else { break }
        } else {
            if count1 > 0 { count1 -= 1 } else { break }
        }
    }
    print(count0 + count1)
}
