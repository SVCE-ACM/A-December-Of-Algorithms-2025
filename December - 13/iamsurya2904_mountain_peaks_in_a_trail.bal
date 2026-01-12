import ballerina/io;
import ballerina/regex;

public function main() {
    string|error line1 = io:readln();
    string|error line2 = io:readln();
    
    if (line2 is string) {
        string[] parts = regex:split(line2, " ");
        int[] heights = [];
        foreach string s in parts {
            if (s != "") {
                heights.push(checkpanic int:fromString(s));
            }
        }
        
        int n = heights.length();
        string result = "";
        boolean found = false;
        
        int i = 1;
        while (i < n - 1) {
            if (heights[i] > heights[i-1] && heights[i] > heights[i+1]) {
                if (found) {
                    result = result + " ";
                }
                result = result + i.toString();
                found = true;
            }
            i = i + 1;
        }
        
        if (!found) {
            io:println("-1");
        } else {
            io:println(result);
        }
    }
}
