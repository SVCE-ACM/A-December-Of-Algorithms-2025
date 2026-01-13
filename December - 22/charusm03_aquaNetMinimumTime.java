import java.util.*;

public class charusm03_aquaNetMinimumTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] water = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            water[i] = sc.nextInt();
            if (water[i] == 1)
                queue.add(i);
        }

        int minutes = 0;
        boolean[] visited = new boolean[V];
        for (int node : queue)
            visited[node] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean progressed = false;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int neighbor : graph.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                        progressed = true;
                    }
                }
            }
            if (progressed)
                minutes++;
        }

        for (boolean v : visited) {
            if (!v) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(minutes);
    }
}
