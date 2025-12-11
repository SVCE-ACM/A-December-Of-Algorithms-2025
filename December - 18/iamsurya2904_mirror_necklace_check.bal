import ballerina/io;
import ballerina/regex;

public function main() {
    string|error line1 = io:readln(); 
    string|error line2 = io:readln(); 
    
    if (line1 is string) {
        string[] p1 = regex:split(line1, "=");
        int n = 0;
        if (p1.length() > 1) {
             n = checkpanic int:fromString(p1[1].trim());
        }
        
        if (n == 0) {
            io:println("The necklace is empty.");
            return;
        }
        
        if (line2 is string) {
            string[] p2 = regex:split(line2, "=");
            string beadsStr = "";
            if (p2.length() > 1) {
                beadsStr = p2[1].trim();
            }
            
            string[] beadsParts = regex:split(beadsStr, " ");
            int[] beads = [];
            foreach string s in beadsParts {
                if (s != "") {
                    beads.push(checkpanic int:fromString(s));
                }
            }
            
            boolean mirrored = true;
            int i = 0;
            int j = n - 1;
            while (i < j) {
                if (beads[i] != beads[j]) {
                    mirrored = false;
                    break;
                }
                i = i + 1;
                j = j - 1;
            }
            
            if (mirrored) {
                io:println("The necklace is mirrored.");
            } else {
                io:println("The necklace is not mirrored.");
            }
        }
    }
}
