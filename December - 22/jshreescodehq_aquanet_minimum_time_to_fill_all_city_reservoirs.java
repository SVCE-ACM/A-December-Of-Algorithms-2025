import java.util.*;

public class AquaNet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] water = new int[V];
        for (int i = 0; i < V; i++) {
            water[i] = sc.nextInt();
        }

        System.out.println(minMinutesToFill(V, graph, water));
        sc.close();
    }

    static int minMinutesToFill(int V, List<List<Integer>> graph, int[] water) {

        Queue<Integer> queue = new LinkedList<>();
        int[] time = new int[V];
        Arrays.fill(time, -1);

        for (int i = 0; i < V; i++) {
            if (water[i] == 1) {
                queue.add(i);
                time[i] = 0;
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : graph.get(curr)) {
                if (time[next] == -1) {
                    time[next] = time[curr] + 1;
                    queue.add(next);
                }
            }
        }

        int maxTime = 0;

        for (int i = 0; i < V; i++) {
            if (time[i] == -1) {
                return -1; 
            }
            maxTime = Math.max(maxTime, time[i]);
        }

        return maxTime;
    }
}
