import java.util.*;

public class devipriya_l_AquaNetFillTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[V];
        Arrays.fill(dist, -1);

        for (int i = 0; i < V; i++) {
            int x = sc.nextInt();
            if (x == 1) {
                q.add(i);
                dist[i] = 0;
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph.get(u)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }

        int ans = 0;
        for (int d : dist) {
            if (d == -1) {
                System.out.println(-1);
                return;
            }
            ans = Math.max(ans, d);
        }
        System.out.println(ans);
    }
}
