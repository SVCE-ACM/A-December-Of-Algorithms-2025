import java.util.*;

public class Main {
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

        int[] water = new int[V];
        for (int i = 0; i < V; i++) water[i] = sc.nextInt();

        Queue<int[]> q = new LinkedList<>(); 
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (water[i] == 1) {
                q.offer(new int[]{i, 0});
                visited[i] = true;
            }
        }

        int time = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int t = cur[1];
            time = Math.max(time, t);

            for (int nei : graph.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.offer(new int[]{nei, t + 1});
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(time);
    }
}
