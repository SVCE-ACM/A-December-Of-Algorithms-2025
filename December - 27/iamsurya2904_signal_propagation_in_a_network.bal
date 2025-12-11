import ballerina/io;
import ballerina/regex;
import ballerina/lang.'int as ints;

public function main() {
    string|error l1 = io:readln(); 
    string|error l2 = io:readln(); 
    
    if (l1 is string && l2 is string) {
        int n = checkpanic int:fromString(l1);
        int m = checkpanic int:fromString(l2);
        
        map<int[][]> adj = {};
        
        int i = 0;
        while (i < m) {
            string|error edgeLine = io:readln();
            if (edgeLine is string) {
                string[] parts = regex:split(edgeLine, " ");
                int u = checkpanic int:fromString(parts[0]);
                int v = checkpanic int:fromString(parts[1]);
                int w = checkpanic int:fromString(parts[2]);
                
                int[][] listU = adj.get(u.toString()) ?: [];
                listU.push([v, w]);
                adj[u.toString()] = listU;
            }
            i = i + 1;
        }
        
        string|error lS = io:readln(); 
        int s = 0;
        if (lS is string) {
           s = checkpanic int:fromString(lS);
        }
        
        int[] dist = [];
        boolean[] visited = [];
        
        i = 0;
        while (i < n) {
            dist.push(2147483647); 
            visited.push(false);
            i = i + 1;
        }
        dist[s] = 0;
        
        int count = 0;
        while (count < n) {
            int u = -1;
            int minVal = 2147483647;
            
            int j = 0;
            while (j < n) {
                if (!visited[j] && dist[j] < minVal) {
                    minVal = dist[j];
                    u = j;
                }
                j = j + 1;
            }
            
            if (u == -1) {
                break;
            }
            
            visited[u] = true;
            
            int[][] neighbors = adj.get(u.toString()) ?: [];
            foreach int[] edge in neighbors {
                int v = edge[0];
                int w = edge[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
            count = count + 1;
        }
        
        int maxDist = 0;
        foreach int d in dist {
            if (d == 2147483647) {
                io:println("-1");
                return;
            }
            if (d > maxDist) {
                maxDist = d;
            }
        }
        
        io:println(maxDist);
    }
}
