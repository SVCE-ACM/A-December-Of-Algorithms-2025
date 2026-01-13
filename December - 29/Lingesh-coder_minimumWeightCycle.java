import java.util.*;

public class Lingesh-coder_minimumWeightCycle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int[][] adj = new int[V][V];
        for (int[] row : adj)
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            adj[u][v] = w;
            adj[v][u] = w;
        }

        int[][] dist = new int[V][V];
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                dist[i][j] = adj[i][j];

        for (int k = 0; k < V; k++)
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

        int minCycle = Integer.MAX_VALUE;
        for (int u = 0; u < V; u++)
            for (int v = u + 1; v < V; v++)
                if (adj[u][v] < Integer.MAX_VALUE / 2)
                    minCycle = Math.min(minCycle, adj[u][v] + dist[u][v] - adj[u][v]);

        System.out.println(minCycle);
    }
}
