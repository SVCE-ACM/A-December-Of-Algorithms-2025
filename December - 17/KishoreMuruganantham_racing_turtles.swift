import Foundation

var lines = [String]()
while let line = readLine() { lines.append(line) }

func parse(_ l: String) -> [Double] {
    var s = l
    if let r = s.range(of: "=") { s = String(s[r.upperBound...]) }
    s = s.replacingOccurrences(of: "[", with: "")
    s = s.replacingOccurrences(of: "]", with: "")
    return s.split(separator: ",").compactMap { Double($0.trimmingCharacters(in: .whitespaces)) }
}

if lines.count >= 4 {
    let target = parse(lines[0]).first ?? 0
    let n = Int(parse(lines[1]).first ?? 0)
    
    if n == 0 {
        print("No turtle fleets formed.")
    } else {
        let pos = parse(lines[2])
        let spd = parse(lines[3])
        
        var turtles = [(Double, Double)]()
        for i in 0..<n {
            if i < pos.count && i < spd.count {
                turtles.append((pos[i], spd[i]))
            }
        }
        
        turtles.sort { $0.0 > $1.0 }
        
        var times = [Double]()
        for t in turtles {
             times.append((target - t.0) / t.1)
        }
        
        var fleets = 0
        var currentMax = 0.0
        
        for time in times {
            if time > currentMax {
                fleets += 1
                currentMax = time
            }
        }
        print("The number of turtle fleets is: \(fleets)")
    }
}
