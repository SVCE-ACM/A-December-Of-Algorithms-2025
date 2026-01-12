import ballerina/io;
import ballerina/lang.value;

public function main() {
    string|error line1 = io:readln();
    string|error line2 = io:readln();
    
    if (line1 is string && line2 is string) {
        json|error studentsJ = value:fromJsonString(line1.substring(line1.indexOf("[") ?: 0));
        json|error sandwichesJ = value:fromJsonString(line2.substring(line2.indexOf("[") ?: 0));
        
        if (studentsJ is int[] && sandwichesJ is int[]) {
            int[] students = studentsJ;
            int[] sandwiches = sandwichesJ;
            
            int ones = 0;
            int zeros = 0;
            foreach int s in students {
                if (s == 1) { ones = ones + 1; }
                else { zeros = zeros + 1; }
            }
            
            int i = 0;
            while (i < sandwiches.length()) {
                int sand = sandwiches[i];
                if (sand == 0) {
                    if (zeros == 0) {
                        break;
                    }
                    zeros = zeros - 1;
                } else {
                    if (ones == 0) {
                        break;
                    }
                    ones = ones - 1;
                }
                i = i + 1;
            }
            
            io:println((sandwiches.length() - i));
        }
    }
}
