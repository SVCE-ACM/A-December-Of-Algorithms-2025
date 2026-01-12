import Foundation

var lines = [String]()
while let line = readLine() { lines.append(line) }

func parseLine(_ l: String) -> String {
    if let r = l.range(of: "=") {
        return String(l[r.upperBound...])
    }
    return l
}

if !lines.isEmpty {
    let nStr = parseLine(lines[0])
    let n = Int(nStr.trimmingCharacters(in: .whitespaces)) ?? 0
    
    if n == 0 {
        print("The necklace is empty.")
    } else {
        if lines.count >= 2 {
            let beadsStr = parseLine(lines[1])
            let beads = beadsStr.split(separator: " ").compactMap { Int($0.trimmingCharacters(in: .whitespaces)) }
            
            let reversedBeads = Array(beads.reversed())
            if beads == reversedBeads {
                 print("The necklace is mirrored.")
            } else {
                 print("The necklace is not mirrored.")
            }
        }
    }
}
