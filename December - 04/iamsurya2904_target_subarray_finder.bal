import ballerina/io;
import ballerina/regex;

public function main() {
    string|error line1 = io:readln();
    if (line1 is string) {
        string[] parts = regex:split(line1, " ");
        if (parts.length() >= 2) {
            int n = checkpanic int:fromString(parts[0]);
            int k = checkpanic int:fromString(parts[1]);
            
            string|error line2 = io:readln();
            if (line2 is string) {
                string[] numsStr = regex:split(line2, " ");
                int[] arr = [];
                foreach string s in numsStr {
                    if (s != "") {
                        arr.push(checkpanic int:fromString(s));
                    }
                }
                
                map<int> prefixSumMap = {};
                int currentSum = 0;
                int startIdx = -1;
                int endIdx = -1;
                
                int i = 0;
                while (i < arr.length()) {
                    currentSum = currentSum + arr[i];
                    
                    if (currentSum == k) {
                        startIdx = 0;
                        endIdx = i;
                        break;
                    }
                    
                    if (prefixSumMap.hasKey((currentSum - k).toString())) {
                        startIdx = (prefixSumMap.get((currentSum - k).toString()) ?: 0) + 1;
                        endIdx = i;
                        break;
                    }
                    
                    prefixSumMap[currentSum.toString()] = i;
                    i = i + 1;
                }
                
                io:println(startIdx.toString() + " " + endIdx.toString());
            }
        }
    }
}
