package Dec29;
import java.util.*;

public class MinimumWeight {

    static class Edge {
        int to, weight;
        Edge(int t, int w) {
            to = t;
            weight = w;
        }
    }

    static final int INF = Integer.MAX_VALUE;

    // Dijkstra to find shortest path from src to dest
    static int dijkstra(List<List<Edge>> graph, int src, int dest) {
        int V = graph.size();
        int[] dist = new int[V];
        Arrays.fill(dist, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        dist[src] = 0;
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int d = cur[1];

            if (node == dest) return d;
            if (d > dist[node]) continue;

            for (Edge e : graph.get(node)) {
                if (dist[e.to] > d + e.weight) {
                    dist[e.to] = d + e.weight;
                    pq.add(new int[]{e.to, dist[e.to]});
                }
            }
        }
        return INF;
    }

    public static int minimumCycle(int V, int[][] edges) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        // Build graph
        for (int[] e : edges) {
            graph.get(e[0]).add(new Edge(e[1], e[2]));
            graph.get(e[1]).add(new Edge(e[0], e[2]));
        }

        int ans = INF;

        // Try removing each edge
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];

            // Remove edge u-v
            graph.get(u).removeIf(x -> x.to == v && x.weight == w);
            graph.get(v).removeIf(x -> x.to == u && x.weight == w);

            int path = dijkstra(graph, u, v);
            if (path != INF) {
                ans = Math.min(ans, path + w);
            }

            // Add edge back
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        return ans == INF ? -1 : ans;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
                {0, 1, 2},
                {1, 2, 2},
                {1, 3, 1},
                {3, 4, 1},
                {0, 4, 3},
                {2, 3, 4}
        };

        System.out.println(minimumCycle(V, edges));
    }
}
