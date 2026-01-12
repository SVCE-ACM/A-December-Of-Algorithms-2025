import ballerina/io;
import ballerina/lang.value;

public function main() {
    string|error inputRaw = io:readln();
    if (inputRaw is string) {
        string cleanInput = inputRaw.substring(inputRaw.indexOf("[") ?: 0);
        json|error j = value:fromJsonString(cleanInput);
        if (j is int[]) {
            int[] stones = j;
            int n = stones.length();
            int maxReach = 0;
            int i = 0;
            boolean canReach = false;
            while (i <= maxReach) {
                if (i == n - 1) {
                    canReach = true;
                    break;
                }
                int currentReach = i + stones[i];
                if (currentReach > maxReach) {
                    maxReach = currentReach;
                }
                if (maxReach >= n - 1) {
                    canReach = true;
                    break;
                }
                i = i + 1;
            }
            io:println(canReach);
        }
    }
}
