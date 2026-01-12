import ballerina/io;
import ballerina/lang.value;

public function main() {
    string|error input = io:readln();
    if (input is string) {
        string clean = input.substring(input.indexOf("[") ?: 0);
        json|error j = value:fromJsonString(clean);
        if (j is json[]) {
            boolean seenNull = false;
            boolean valid = true;
            
            foreach json val in j {
                if (val == null) {
                    seenNull = true;
                } else {
                    if (seenNull) {
                        valid = false;
                        break;
                    }
                }
            }
            io:println(valid);
        }
    }
}
