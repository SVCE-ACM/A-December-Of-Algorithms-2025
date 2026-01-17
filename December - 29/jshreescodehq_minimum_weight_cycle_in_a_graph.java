import java.util.*;

public class MinimumWeightCycle {

    static final int INF = (int)1e9;

    public static void main(String[] args) {

        int V = 5;
        int[][] edges = {
                {0, 1, 2},
                {1, 2, 2},
                {1, 3, 1},
                {1, 4, 1},
                {0, 4, 3},
                {2, 3, 4}
        };

        System.out.println(findMinCycle(V, edges));
    }

    static int findMinCycle(int V, int[][] edges) {

        int[][] dist = new int[V][V];

        for (int i = 0; i < V; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            dist[u][v] = Math.min(dist[u][v], w);
            dist[v][u] = Math.min(dist[v][u], w);
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int ans = INF;
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            if (dist[u][v] != INF) {
                ans = Math.min(ans, dist[u][v] + w);
            }
        }

        return ans;
    }
}
