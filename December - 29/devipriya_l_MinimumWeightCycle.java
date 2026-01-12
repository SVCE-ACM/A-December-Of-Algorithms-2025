import java.util.*;

public class devipriya_l_MinimumWeightCycle {

    static final int INF = (int)1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] dist = new int[V][V];
        for (int i = 0; i < V; i++)
            Arrays.fill(dist[i], INF);

        for (int i = 0; i < V; i++) dist[i][i] = 0;

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            dist[u][v] = Math.min(dist[u][v], w);
            dist[v][u] = Math.min(dist[v][u], w);
        }

        int ans = INF;

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < k; i++) {
                for (int j = i + 1; j < k; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF && dist[i][j] < INF) {
                        ans = Math.min(ans, dist[i][k] + dist[k][j] + dist[i][j]);
                    }
                }
            }
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    if (dist[i][k] < INF && dist[k][j] < INF)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        }

        System.out.println(ans == INF ? -1 : ans);
    }
}
