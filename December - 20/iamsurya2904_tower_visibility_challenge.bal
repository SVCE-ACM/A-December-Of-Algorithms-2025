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
        int[] result = [];
        int k = 0;
        while (k < n) {
            result.push(-1);
            k = k + 1;
        }
        
        int[] stack = []; 
        
        int i = 0;
        while (i < n) {
            while (stack.length() > 0 && heights[stack[stack.length() - 1]] < heights[i]) {
                int idx = stack.pop();
                result[idx] = heights[i];
            }
            stack.push(i);
            i = i + 1;
        }
        
        string outStr = "";
        foreach int val in result {
            outStr = outStr + val.toString() + " ";
        }
        io:println(outStr.trim());
    }
}
