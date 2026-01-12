import ballerina/io;

function toBinary(int n) returns string {
    if (n == 0) { return "0"; }
    string binary = "";
    int num = n;
    while (num > 0) {
        binary = (num % 2).toString() + binary;
        num = num / 2;
    }
    return binary;
}

function toOctal(int n) returns string {
    if (n == 0) { return "0"; }
    string octal = "";
    int num = n;
    while (num > 0) {
        octal = (num % 8).toString() + octal;
        num = num / 8;
    }
    return octal;
}

function pad(string s, int width) returns string {
    string res = s;
    while (res.length() < width) {
        res = " " + res;
    }
    return res;
}

public function main() {
    string|error input = io:readln();
    if (input is string) {
        int|error n = int:fromString(input);
        if (n is int) {
            int i = 1;
            while (i <= n) {
                string dec = i.toString();
                string oct = toOctal(i);
                string hex = i.toHexString().toUpperAscii();
                string bin = toBinary(i);
                io:println(pad(dec, 5) + " " + pad(oct, 5) + " " + pad(hex, 5) + " " + pad(bin, 6)); 
                i = i + 1;
            }
        }
    }
}
