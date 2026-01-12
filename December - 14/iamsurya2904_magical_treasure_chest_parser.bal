import ballerina/io;
import ballerina/lang.value;

public function main() {
    string|error input = io:readln();
    if (input is string) {
        string clean = input;
        if (clean.startsWith("\"") && clean.endsWith("\"")) {
            clean = clean.substring(1, clean.length() - 1);
        }
        
        json|error j = value:fromJsonString(clean);
        if (j is json) {
             io:println(j.toString());
        } else {
            io:println(clean);
        }
    }
}
