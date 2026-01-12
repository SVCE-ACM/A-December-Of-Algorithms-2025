import ballerina/io;

public function main() {
    string|error input = io:readln();
    if (input is string) {
        int|error n = int:fromString(input);
        if (n is int) {
            int count = 0;
            int i = 1;
            string result = "";
            while (true) {
                int sq = i * i;
                if (sq > n) {
                    break;
                }
                if (count > 0) {
                    result = result + " ";
                }
                result = result + sq.toString();
                count = count + 1;
                i = i + 1;
            }
            io:println(result);
            io:println(count);
        }
    }
}
