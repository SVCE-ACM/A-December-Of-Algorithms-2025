import java.util.*;

public class SignalPropagation {

    static class Edge {
        int to, time;
        Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }

    static class Node {
        int id, dist;
        Node(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int t = sc.nextInt();
            graph.get(u).add(new Edge(v, t));
        }

        int S = sc.nextInt();

        System.out.println(minTimeToReachAll(N, graph, S));
        sc.close();
    }

    static int minTimeToReachAll(int N, List<List<Edge>> graph, int S) {

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        PriorityQueue<Node> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));

        pq.add(new Node(S, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.dist > dist[curr.id]) continue;

            for (Edge e : graph.get(curr.id)) {
                int newDist = dist[curr.id] + e.time;
                if (newDist < dist[e.to]) {
                    dist[e.to] = newDist;
                    pq.add(new Node(e.to, newDist));
                }
            }
        }

        int maxTime = 0;
        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; 
            }
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
