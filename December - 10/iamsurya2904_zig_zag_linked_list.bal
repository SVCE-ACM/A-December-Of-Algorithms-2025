import ballerina/io;
import ballerina/regex;

public function main() {
    string|error line1 = io:readln();
    string|error line2 = io:readln();
    
    if (line2 is string) {
        string cleanLine2 = line2;
        int idx = cleanLine2.indexOf(":");
        if (idx is int) {
            cleanLine2 = cleanLine2.substring(idx + 1);
        }
        
        string[] parts = regex:split(cleanLine2, " ");
        int[] values = [];
        foreach string s in parts {
            string trimmed = s.trim();
            if (trimmed != "") {
                values.push(checkpanic int:fromString(trimmed));
            }
        }
        
        int n = values.length();
        int left = 0;
        int right = n - 1;
        string result = "";
        
        while (left <= right) {
            if (left == right) {
                result = result + values[left].toString() + " ";
            } else {
                result = result + values[left].toString() + " " + values[right].toString() + " ";
            }
            left = left + 1;
            right = right - 1;
        }
        
        io:println(result.trim());
    }
}
