package Dec22;
import java.util.*;
        public class aquanet {
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

                Queue<Integer> queue = new LinkedList<>();
                int[] time = new int[V];
                Arrays.fill(time, -1);

                for (int i = 0; i < V; i++) {
                    if (water[i] == 1) {
                        queue.offer(i);
                        time[i] = 0;
                    }
                }

                while (!queue.isEmpty()) {
                    int curr = queue.poll();

                    for (int neighbor : graph.get(curr)) {
                        if (time[neighbor] == -1) {
                            time[neighbor] = time[curr] + 1;
                            queue.offer(neighbor);
                        }
                    }
                }

                int maxTime = 0;
                for (int t : time) {
                    if (t == -1) {
                        System.out.println(-1);
                        return;
                    }
                    maxTime = Math.max(maxTime, t);
                }

                System.out.println(maxTime);
            }
        }

