package Dec27;
import java.util.*;
    public class SignalPropagation {

        static class Edge {
            int to, time;
            Edge(int to, int time) {
                this.to = to;
                this.time = time;
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

            // Read edges
            for (int i = 0; i < M; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int t = sc.nextInt();
                graph.get(u).add(new Edge(v, t));
            }

            int source = sc.nextInt();

            int result = minTimeToReachAll(N, graph, source);
            System.out.println(result);
        }

        static int minTimeToReachAll(int N, List<List<Edge>> graph, int source) {
            int[] dist = new int[N];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[source] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (a, b) -> a[1] - b[1]
            );
            pq.offer(new int[]{source, 0});

            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int node = curr[0];
                int time = curr[1];

                if (time > dist[node]) continue;

                for (Edge e : graph.get(node)) {
                    if (dist[e.to] > time + e.time) {
                        dist[e.to] = time + e.time;
                        pq.offer(new int[]{e.to, dist[e.to]});
                    }
                }
            }

            int maxTime = 0;
            for (int d : dist) {
                if (d == Integer.MAX_VALUE) return -1;
                maxTime = Math.max(maxTime, d);
            }

            return maxTime;
        }
    }


