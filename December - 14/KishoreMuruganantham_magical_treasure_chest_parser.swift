import Foundation

enum Nested {
    case value(Int)
    case list([Nested])
    
    var description: String {
        switch self {
        case .value(let v): return String(v)
        case .list(let l): return "[" + l.map { $0.description }.joined(separator: ",") + "]"
        }
    }
}

if let line = readLine() {
    var input = line.trimmingCharacters(in: .whitespaces)
    if input.hasPrefix("\"") && input.hasSuffix("\"") {
        input.removeFirst()
        input.removeLast()
    }
    input = input.replacingOccurrences(of: " ", with: "")
    let chars = Array(input)
    var pos = 0
    
    func parse() -> Nested? {
        if pos >= chars.count { return nil }
        
        if chars[pos] == "[" {
            pos += 1
            var list = [Nested]()
            if pos < chars.count && chars[pos] == "]" {
                pos += 1
                return .list(list)
            }
            while pos < chars.count {
                if let elem = parse() {
                    list.append(elem)
                }
                if pos < chars.count {
                    if chars[pos] == "]" {
                        pos += 1
                        return .list(list)
                    } else if chars[pos] == "," {
                        pos += 1
                    }
                } else {
                    break
                }
            }
            return .list(list)
        } else {
            let start = pos
            while pos < chars.count {
                let c = chars[pos]
                if c == "-" || c.isNumber {
                    pos += 1
                } else {
                    break
                }
            }
            if start < pos {
                let s = String(chars[start..<pos])
                if let val = Int(s) {
                    return .value(val)
                }
            }
            return nil
        }
    }
    
    if let result = parse() {
        print(result.description)
    }
}
