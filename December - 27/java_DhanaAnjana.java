import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class java_DhanaAnjana {
    static class Edge implements Comparable<Edge> {
        int to, time;
        Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }
        public int compareTo(Edge other) {
            return this.time - other.time;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int t = scanner.nextInt();
            graph.get(u).add(new Edge(v, t));
        }
        
        int source = scanner.nextInt();
        
        int result = dijkstra(graph, source, n);
        System.out.println(result);
        
        scanner.close();
    }
    
    static int dijkstra(List<List<Edge>> graph, int source, int n) {
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[source] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(source, 0));
        
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            
            if (current.time > dist[current.to]) {
                continue;
            }
            
            for (Edge edge : graph.get(current.to)) {
                int newDist = dist[current.to] + edge.time;
                if (newDist < dist[edge.to]) {
                    dist[edge.to] = newDist;
                    pq.add(new Edge(edge.to, newDist));
                }
            }
        }
        
        int maxTime = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, dist[i]);
        }
        
        return maxTime;
    }
}
