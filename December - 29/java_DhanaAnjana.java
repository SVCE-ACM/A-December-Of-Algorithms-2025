import java.util.Scanner;

public class java_DhanaAnjana {
    static class Edge {
        int u, v, weight;
        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }
    
    static class UnionFind {
        int[] parent, rank;
        
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        boolean union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) return false;
            
            if (rank[x] < rank[y]) {
                parent[x] = y;
            } else if (rank[x] > rank[y]) {
                parent[y] = x;
            } else {
                parent[y] = x;
                rank[x]++;
            }
            return true;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int v = scanner.nextInt();
        int edgeCount = scanner.nextInt();
        
        Edge[] edges = new Edge[edgeCount];
        for (int i = 0; i < edgeCount; i++) {
            int u = scanner.nextInt();
            int v_node = scanner.nextInt();
            int w = scanner.nextInt();
            edges[i] = new Edge(u, v_node, w);
        }
        
        java.util.Arrays.sort(edges, (a, b) -> a.weight - b.weight);
        
        int minCycle = Integer.MAX_VALUE;
        
        for (int excludeIdx = 0; excludeIdx < edgeCount; excludeIdx++) {
            UnionFind uf = new UnionFind(v);
            int mstWeight = 0;
            int edgesUsed = 0;
            
            for (int i = 0; i < edgeCount; i++) {
                if (i == excludeIdx) continue;
                
                if (uf.union(edges[i].u, edges[i].v)) {
                    mstWeight += edges[i].weight;
                    edgesUsed++;
                }
            }
            
            if (edgesUsed == v - 1) {
                minCycle = Math.min(minCycle, mstWeight + edges[excludeIdx].weight);
            }
        }
        
        System.out.println(minCycle);
        scanner.close();
    }
}
