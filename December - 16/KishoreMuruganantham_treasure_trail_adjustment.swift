import Foundation

if let line = readLine() {
    var vals = [Int]()
    var n = 0
    
    if let range = line.range(of: "n", options: .backwards) {
         let part1 = String(line[..<range.lowerBound])
         let part2 = String(line[range.upperBound...])
         
         var s1 = part1
         if let r1 = s1.range(of: "=") {
             s1 = String(s1[r1.upperBound...])
         }
         s1 = s1.replacingOccurrences(of: "[", with: "")
         s1 = s1.replacingOccurrences(of: "]", with: "")
         s1 = s1.replacingOccurrences(of: ",", with: " ") // cleanup trailing comma
         
         vals = s1.split(separator: " ").compactMap { Int($0.trimmingCharacters(in: CharacterSet(charactersIn: " ,"))) }
         
         var s2 = part2
         if let r2 = s2.range(of: "=") {
             s2 = String(s2[r2.upperBound...])
         }
         if let val = Int(s2.trimmingCharacters(in: .whitespaces)) {
             n = val
         }
    }
    
    let idx = vals.count - n
    if idx >= 0 && idx < vals.count {
        vals.remove(at: idx)
    }
    
    print("[" + vals.map{ String($0) }.joined(separator: ",") + "]")
}
