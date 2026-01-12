import ballerina/io;
import ballerina/lang.value;
import ballerina/regex;

public function main() {
    string|error line1 = io:readln();
    if (line1 is string) {
        int idxOpen = line1.indexOf("[") ?: 0;
        int idxClose = line1.indexOf("]") ?: 0;
        string arrStr = line1.substring(idxOpen, idxClose + 1);
        
        int idxN = line1.indexOf("n =");
        int n = 0;
        if (idxN is int) {
             string nStr = line1.substring(idxN + 3).trim();
             int|error val = int:fromString(nStr);
             if (val is int) { n = val; }
        }
        
        json|error j = value:fromJsonString(arrStr);
        if (j is int[]) {
            int[] head = j;
            int len = head.length();
            
            if (n > 0 && n <= len) {
                int removeIdx = len - n;
                _ = head.remove(removeIdx);
            }
            
            io:println(head.toString());
        }
    }
}
