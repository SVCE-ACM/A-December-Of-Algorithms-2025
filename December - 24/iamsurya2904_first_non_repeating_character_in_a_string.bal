import ballerina/io;

public function main() {
    string|error input = io:readln();
    if (input is string) {
        map<int> freq = {};
        int i = 0;
        while (i < input.length()) {
            string charStr = input.substring(i, i+1);
            int count = freq.get(charStr) ?: 0;
            freq[charStr] = count + 1;
            i = i + 1;
        }
        
        string result = "";
        i = 0;
        while (i < input.length()) {
            string charStr = input.substring(i, i+1);
            if ((freq.get(charStr) ?: 0) == 1) {
                result = charStr;
                break;
            }
            i = i + 1;
        }
        
        if (result != "") {
             io:println("The first non-repeating character is: " + result);
        } else {
             io:println("No non-repeating character found.");
        }
    }
}
