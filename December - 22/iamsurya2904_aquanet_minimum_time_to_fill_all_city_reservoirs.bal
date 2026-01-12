import ballerina/io;
import ballerina/regex;

public function main() {
    string|error line1 = io:readln();
    if (line1 is string) {
        string[] p1 = regex:split(line1, " ");
        int v = checkpanic int:fromString(p1[0]);
        int e = checkpanic int:fromString(p1[1]);
        
        map<int[]> adj = {};
        
        int i = 0;
        while (i < e) {
            string|error edgeLine = io:readln();
            if (edgeLine is string) {
                string[] ep = regex:split(edgeLine, " ");
                int u = checkpanic int:fromString(ep[0]);
                int val = checkpanic int:fromString(ep[1]);
                
                int[] listU = adj.get(u.toString()) ?: [];
                listU.push(val);
                adj[u.toString()] = listU;
                
                int[] listV = adj.get(val.toString()) ?: [];
                listV.push(u);
                adj[val.toString()] = listV;
            }
            i = i + 1;
        }
        
        string|error waterLine = io:readln();
        if (waterLine is string) {
            string[] wp = regex:split(waterLine, " ");
            int[] queue = []; 
            int[] dist = [];
            int k = 0;
            while (k < v) {
                dist.push(-1);
                k = k + 1;
            }
            
            k = 0;
            foreach string s in wp {
                if (s != "") {
                    int val = checkpanic int:fromString(s);
                    if (val == 1) {
                        queue.push(k);
                        dist[k] = 0;
                    }
                    k = k + 1;
                }
            }
            
            int maxTime = 0;
            int countFilled = queue.length();
            
            while (queue.length() > 0) {
                int curr = queue.remove(0); 
                int[] neighbors = adj.get(curr.toString()) ?: [];
                
                foreach int neighbor in neighbors {
                    if (dist[neighbor] == -1) {
                        dist[neighbor] = dist[curr] + 1;
                        if (dist[neighbor] > maxTime) {
                            maxTime = dist[neighbor];
                        }
                        queue.push(neighbor);
                        countFilled = countFilled + 1;
                    }
                }
            }
            
            if (countFilled == v) {
                io:println(maxTime);
            } else {
                io:println("-1");
            }
        }
    }
}
