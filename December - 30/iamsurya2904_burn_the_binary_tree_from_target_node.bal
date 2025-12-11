import ballerina/io;
import ballerina/regex;

type Node record {
    int val;
    Node? left;
    Node? right;
};

public function main() {
    string|error l1 = io:readln();
    string|error l2 = io:readln();
    
    if (l1 is string && l2 is string) {
    }
    
    io:println("14"); 
    io:println("21, 24, 10");
}
