import ballerina/io;

public function main() {
    string|error input = io:readln();
    if (input is string) {
        string clean = input;
        int idx = clean.indexOf(":");
        if (idx is int) {
            clean = clean.substring(idx + 1).trim();
        }
        int|error n = int:fromString(clean);
        if (n is int) {
            if (n <= 2) {
                io:println("The count of prime numbers less than " + n.toString() + " is: 0");
                return;
            }
            
            boolean[] isPrime = [];
            int i = 0;
            while (i < n) {
                isPrime.push(true);
                i = i + 1;
            }
            isPrime[0] = false;
            isPrime[1] = false;
            
            i = 2;
            while (i * i < n) {
                if (isPrime[i]) {
                    int j = i * i;
                    while (j < n) {
                        isPrime[j] = false;
                        j = j + i;
                    }
                }
                i = i + 1;
            }
            
            int count = 0;
            i = 2;
            while (i < n) {
                if (isPrime[i]) {
                    count = count + 1;
                }
                i = i + 1;
            }
            io:println("The count of prime numbers less than " + n.toString() + " is: " + count.toString());
        }
    }
}
