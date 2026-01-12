import ballerina/io;
import ballerina/regex;

public function main() {
    string|error line1 = io:readln();
    if (line1 is string) {
        string|error line2 = io:readln();
        if (line2 is string) {
            string[] parts = regex:split(line2, " ");
            map<int> freq = {};
            foreach string s in parts {
                if (s != "") {
                    int val = checkpanic int:fromString(s);
                    string key = val.toString();
                    int count = freq.get(key) ?: 0;
                    freq[key] = count + 1;
                }
            }
            
            int sum = 0;
            foreach [string, int] entry in freq.entries() {
                if (entry[1] == 1) {
                    sum = sum + checkpanic int:fromString(entry[0]);
                }
            }
            io:println(sum);
        }
    }
}
