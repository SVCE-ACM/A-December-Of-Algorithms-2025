import java.util.*;

public class Magesh2424_AquaNetMinimumTimeToFillReservoirs {

    static class Node {
        int v;
        int time;

        Node(int v, int time) {
            this.v = v;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read V and E
        int V = sc.nextInt();
        int E = sc.nextInt();

        // Build graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Read edges
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Read initial water states
        int[] water = new int[V];
        for (int i = 0; i < V; i++) {
            water[i] = sc.nextInt();
        }

        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];

        // Add all initially filled reservoirs (multi-source BFS)
        for (int i = 0; i < V; i++) {
            if (water[i] == 1) {
                queue.offer(new Node(i, 0));
                visited[i] = true;
            }
        }

        int maxTime = 0;

        // BFS traversal
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            maxTime = Math.max(maxTime, curr.time);

            for (int nei : graph.get(curr.v)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    queue.offer(new Node(nei, curr.time + 1));
                }
            }
        }

        // Check if all reservoirs are filled
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                System.out.println(-1);
                sc.close();
                return;
            }
        }

        // Output result
        System.out.println(maxTime);

        sc.close();
    }
}
