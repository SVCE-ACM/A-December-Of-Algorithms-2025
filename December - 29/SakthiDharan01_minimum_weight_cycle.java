import java.util.*;

public class SakthiDharan01_minimum_weight_cycle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int V = sc.nextInt();
        List<int[]> edges = new ArrayList<>();
        while (sc.hasNextInt()){
            int u = sc.nextInt();
            if (!sc.hasNextInt()) break;
            int v = sc.nextInt();
            if (!sc.hasNextInt()) break;
            int w = sc.nextInt();
            edges.add(new int[]{u, v, w});
        }
        long INF = (long) 1e18;
        long[][] dist = new long[V][V];
        for (int i = 0; i < V; i++) Arrays.fill(dist[i], INF);
        for (int i = 0; i < V; i++) dist[i][i] = 0;
        for (int[] e : edges){
            int u = e[0], v = e[1], w = e[2];
            dist[u][v] = Math.min(dist[u][v], w);
            dist[v][u] = Math.min(dist[v][u], w);
        }
        long ans = INF;
        for (int k = 0; k < V; k++){
            for (int i = 0; i < k; i++){
                for (int j = i + 1; j < k; j++){
                    if (dist[i][j] < INF && dist[i][k] < INF && dist[k][j] < INF){
                        ans = Math.min(ans, dist[i][j] + dist[i][k] + dist[k][j]);
                    }
                }
            }
            for (int i = 0; i < V; i++){
                for (int j = 0; j < V; j++){
                    long nd = dist[i][k] + dist[k][j];
                    if (nd < dist[i][j]) dist[i][j] = nd;
                }
            }
        }
        System.out.println(ans < INF ? ans : -1);
        sc.close();
    }
}
