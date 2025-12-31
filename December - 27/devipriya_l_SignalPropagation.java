import java.util.*;

public class devipriya_l_SignalPropagation {

    static class Edge {
        int v, w;
        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int t = sc.nextInt();
            graph.get(u).add(new Edge(v, t));
        }

        int S = sc.nextInt();
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        PriorityQueue<int[]> pq =
            new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{S, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];
            if (d > dist[u]) continue;

            for (Edge e : graph.get(u)) {
                if (dist[e.v] > dist[u] + e.w) {
                    dist[e.v] = dist[u] + e.w;
                    pq.add(new int[]{e.v, dist[e.v]});
                }
            }
        }

        int ans = 0;
        for (int d : dist) {
            if (d == Integer.MAX_VALUE) {
                System.out.println(-1);
                return;
            }
            ans = Math.max(ans, d);
        }

        System.out.println(ans);
    }
}
