import ballerina/io;
import ballerina/regex;
import ballerina/lang.'int as ints;

public function main() {
    string|error l1 = io:readln();
    string|error l2 = io:readln();
    
    if (l2 is string) {
        string[] parts = regex:split(l2, " ");
        int[] ratings = [];
        foreach string s in parts {
            if (s != "") {
                ratings.push(checkpanic int:fromString(s));
            }
        }
        
        int n = ratings.length();
        int[] candies = [];
        int i = 0;
        while (i < n) {
            candies.push(1);
            i = i + 1;
        }
        
        i = 1;
        while (i < n) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
            i = i + 1;
        }
        
        i = n - 2;
        while (i >= 0) {
            if (ratings[i] > ratings[i+1]) {
                 int val = candies[i+1] + 1;
                 if (val > candies[i]) {
                     candies[i] = val;
                 }
            }
            i = i - 1;
        }
        
        int sum = 0;
        foreach int c in candies {
            sum = sum + c;
        }
        io:println(sum);
    }
}
