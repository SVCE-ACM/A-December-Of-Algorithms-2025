import ballerina/io;
import ballerina/regex;

public function main() {
    string|error line1 = io:readln();
    string|error line2 = io:readln();
    
    if (line2 is string) {
        string[] parts = regex:split(line2, " ");
        int[] nums = [];
        foreach string s in parts {
            if (s != "") {
                nums.push(checkpanic int:fromString(s));
            }
        }
        
        int n = nums.length();
        int[] arr = nums; 
        
        int i = 0;
        while (i < n) {
            while (arr[i] != arr[arr[i] - 1]) {
                int correctIdx = arr[i] - 1;
                int temp = arr[i];
                arr[i] = arr[correctIdx];
                arr[correctIdx] = temp;
            }
            i = i + 1;
        }
        
        int missing = -1;
        int duplicate = -1;
        
        i = 0;
        while (i < n) {
            if (arr[i] != i + 1) {
                duplicate = arr[i];
                missing = i + 1;
                break;
            }
            i = i + 1;
        }
        
        io:println("Missing Number: " + missing.toString());
        io:println("Duplicate Number: " + duplicate.toString());
    }
}
