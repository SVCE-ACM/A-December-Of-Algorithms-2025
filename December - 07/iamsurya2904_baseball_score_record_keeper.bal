import ballerina/io;
import ballerina/lang.value;

public function main() {
    string|error input = io:readln();
    if (input is string) {
        string clean = input.substring(input.indexOf("[") ?: 0);
        json|error j = value:fromJsonString(clean);
        if (j is string[]) {
            int[] stack = [];
            foreach string op in j {
                if (op == "C") {
                    if (stack.length() > 0) {
                        _ = stack.pop();
                    }
                } else if (op == "D") {
                    if (stack.length() > 0) {
                        int last = stack[stack.length() - 1];
                        stack.push(last * 2);
                    }
                } else if (op == "+") {
                    if (stack.length() >= 2) {
                        int last = stack[stack.length() - 1];
                        int prev = stack[stack.length() - 2];
                        stack.push(last + prev);
                    }
                } else {
                    int|error val = int:fromString(op);
                    if (val is int) {
                        stack.push(val);
                    }
                }
            }
            int total = 0;
            foreach int v in stack {
                total = total + v;
            }
            io:println(total);
        }
    }
}
