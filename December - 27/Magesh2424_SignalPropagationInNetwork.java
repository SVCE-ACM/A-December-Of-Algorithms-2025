import java.util.*;

public class Magesh2424_SignalPropagationInNetwork {

    static class Edge {
        int to;
        int time;

        Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }

    static class Node implements Comparable<Node> {
        int v;
        int dist;

        Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node other) {
            return this.dist - other.dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of towers
        int N = sc.nextInt();

        // Read number of directed links
        int M = sc.nextInt();

        // Build graph
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        // Read edges
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int t = sc.nextInt();
            graph.get(u).add(new Edge(v, t));
        }

        // Read source tower
        int S = sc.nextInt();

        // Dijkstra initialization
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(S, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.dist > dist[curr.v]) continue;

            for (Edge e : graph.get(curr.v)) {
                int newDist = curr.dist + e.time;
                if (newDist < dist[e.to]) {
                    dist[e.to] = newDist;
                    pq.offer(new Node(e.to, newDist));
                }
            }
        }

        int maxTime = 0;

        // Check reachability and compute max time
        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(-1);
                sc.close();
                return;
            }
            maxTime = Math.max(maxTime, dist[i]);
        }

        // Output result
        System.out.println(maxTime);

        sc.close();
    }
}
