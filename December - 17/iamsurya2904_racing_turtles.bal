import ballerina/io;
import ballerina/regex;
import ballerina/lang.value;

type Turtle record {
    int p;
    int s;
};

public function main() {
    string|error line1 = io:readln(); 
    string|error line2 = io:readln(); 
    string|error line3 = io:readln(); 
    string|error line4 = io:readln(); 
    
    if (line1 is string && line2 is string && line3 is string && line4 is string) {
        int target = parseVal(line1);
        int n = parseVal(line2);
        
        if (n == 0) {
             io:println("No turtle fleets formed.");
             return;
        }

        int[] pos = parseArray(line3);
        int[] spd = parseArray(line4);
        
        Turtle[] turtles = [];
        int i = 0;
        while (i < n) {
            turtles.push({p: pos[i], s: spd[i]});
            i = i + 1;
        }
        
        quickSort(turtles, 0, n - 1);
        
        int fleets = 0;
        float maxTime = -1.0;
        
        foreach Turtle t in turtles {
            float time = <float>(target - t.p) / <float>t.s;
            if (time > maxTime) {
                fleets = fleets + 1;
                maxTime = time;
            }
        }
        
        io:println("The number of turtle fleets is: " + fleets.toString());
    }
}

function parseVal(string line) returns int {
    int idx = line.indexOf("=");
    if (idx is int) {
        string s = line.substring(idx + 1).trim();
        int|error v = int:fromString(s);
        if (v is int) { return v; }
    }
    return 0;
}

function parseArray(string line) returns int[] {
    int idx = line.indexOf("[");
    if (idx is int) {
        string s = line.substring(idx);
        json|error j = value:fromJsonString(s);
        if (j is int[]) { return j; }
    }
    return [];
}

function quickSort(Turtle[] arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

function partition(Turtle[] arr, int low, int high) returns int {
    int pivot = arr[high].p;
    int i = (low - 1);
    int j = low;
    while (j < high) {
        if (arr[j].p > pivot) { 
            i = i + 1;
            Turtle temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        j = j + 1;
    }
    Turtle temp2 = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp2;
    return i + 1;
}
