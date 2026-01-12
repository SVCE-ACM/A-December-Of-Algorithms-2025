/*
 * Problem: Minimum Time for Signal to Reach All Nodes
 *
 * Graph Type:
 * -----------
 * Directed graph with weighted edges.
 *
 * Goal:
 * -----
 * Find shortest time from source S to every node.
 * Answer = maximum of all shortest distances.
 * If any node unreachable → return -1.
 *
 * Algorithm:
 * ----------
 * Classic Dijkstra using Priority Queue
 *
 * Steps:
 * 1. Build adjacency list (node -> (neighbor, weight))
 * 2. Run Dijkstra from source S
 * 3. Track shortest dist[] array
 * 4. If any dist = INF → unreachable
 * 5. Otherwise return max(dist)
 *
 * Complexity:
 * -----------
 * Time  : O(M log N)
 * Space : O(N + M)
 */

import java.util.*;

public class Main {

    static class Pair {
        int node, time;
        Pair(int n, int t) { node = n; time = t; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++)
            graph.add(new ArrayList<>());

        // Read edges
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int t = sc.nextInt();
            graph.get(u).add(new Pair(v, t));
        }

        int S = sc.nextInt();

        System.out.println(dijkstra(graph, N, S));
    }

    private static int dijkstra(List<List<Pair>> graph, int N, int S) {

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.offer(new Pair(S, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            if (cur.time > dist[cur.node]) continue;

            for (Pair next : graph.get(cur.node)) {
                int newTime = cur.time + next.time;

                if (newTime < dist[next.node]) {
                    dist[next.node] = newTime;
                    pq.offer(new Pair(next.node, newTime));
                }
            }
        }

        int ans = 0;
        for (int d : dist) {
            if (d == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, d);
        }

        return ans;
    }
}
