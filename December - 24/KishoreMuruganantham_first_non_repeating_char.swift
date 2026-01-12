import Foundation
if let line = readLine() {
    let chars = Array(line)
    var counts = [Character: Int]()
    for c in chars {
        counts[c, default: 0] += 1
    }
    
    var found = false
    for c in chars {
        if counts[c] == 1 {
            print("The first non-repeating character is: \(c)")
            found = true
            break
        }
    }
    
    if !found {
        print("No non-repeating character found.")
    }
}
