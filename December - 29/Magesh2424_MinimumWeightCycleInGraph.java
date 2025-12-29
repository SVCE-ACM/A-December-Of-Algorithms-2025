import java.util.*;

public class Magesh2424_MinimumWeightCycleInGraph {

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int v, dist;

        Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }

        public int compareTo(Node other) {
            return this.dist - other.dist;
        }
    }

    // Dijkstra shortest path from src to dest, ignoring one edge
    static int dijkstra(int V, List<List<Edge>> graph,
                        int src, int dest,
                        int ignoreU, int ignoreV, int ignoreW) {

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.dist > dist[curr.v]) continue;
            if (curr.v == dest) return curr.dist;

            for (Edge e : graph.get(curr.v)) {

                // Ignore the selected edge (undirected)
                if ((curr.v == ignoreU && e.to == ignoreV && e.weight == ignoreW) ||
                    (curr.v == ignoreV && e.to == ignoreU && e.weight == ignoreW)) {
                    continue;
                }

                int newDist = curr.dist + e.weight;
                if (newDist < dist[e.to]) {
                    dist[e.to] = newDist;
                    pq.offer(new Node(e.to, newDist));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of vertices
        int V = sc.nextInt();

        // Read number of edges
        int E = sc.nextInt();

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        int[][] edges = new int[E][3];

        // Read edges
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            edges[i][0] = u;
            edges[i][1] = v;
            edges[i][2] = w;

            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        int minCycle = Integer.MAX_VALUE;

        // Try each edge as part of a cycle
        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            int dist = dijkstra(V, graph, u, v, u, v, w);
            if (dist != Integer.MAX_VALUE) {
                minCycle = Math.min(minCycle, dist + w);
            }
        }

        // Output result
        if (minCycle == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minCycle);
        }

        sc.close();
    }
}
