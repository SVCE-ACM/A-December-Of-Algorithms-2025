import Foundation
if let line = readLine() {
    var l = line
    if let r = l.range(of: "=") {
        l = String(l[r.upperBound...])
    }
    l = l.replacingOccurrences(of: "[", with: "")
    l = l.replacingOccurrences(of: "]", with: "")
    l = l.replacingOccurrences(of: " ", with: "")
    
    let parts = l.split(separator: ",")
    var valid = true
    var seenNull = false
    
    for p in parts {
        let s = String(p)
        if s == "null" {
            seenNull = true
        } else {
            if seenNull {
                valid = false
                break
            }
        }
    }
    print(valid ? "true" : "false")
}
