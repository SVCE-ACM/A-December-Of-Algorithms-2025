import ballerina/io;
import ballerina/regex;

public function main() {
    string|error line1 = io:readln();
    string|error line2 = io:readln();
    
    if (line2 is string) {
        string[] parts = regex:split(line2, " ");
        int[] skills = [];
        int totalSum = 0;
        foreach string s in parts {
            if (s != "") {
                int val = checkpanic int:fromString(s);
                skills.push(val);
                totalSum = totalSum + val;
            }
        }
        
        int n = skills.length();
        int target = totalSum / 2;
        boolean[] dp = [];
        int idx = 0;
        while (idx <= target) {
            dp.push(false);
            idx = idx + 1;
        }
        dp[0] = true;
        
        foreach int skill in skills {
            int j = target;
            while (j >= skill) {
                if (dp[j - skill]) {
                    dp[j] = true;
                }
                j = j - 1;
            }
        }
        
        int bestSum = 0;
        int k = target;
        while (k >= 0) {
            if (dp[k]) {
                bestSum = k;
                break;
            }
            k = k - 1;
        }
        
        int diff = (totalSum - bestSum) - bestSum;
        io:println(diff);
    }
}
