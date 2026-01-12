import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class java_DhanaAnjana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int v = scanner.nextInt();
        int e = scanner.nextInt();
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < e; i++) {
            int u = scanner.nextInt();
            int v_node = scanner.nextInt();
            graph.get(u).add(v_node);
            graph.get(v_node).add(u);
        }
        
        int[] initial = new int[v];
        for (int i = 0; i < v; i++) {
            initial[i] = scanner.nextInt();
        }
        
        int time = bfs(graph, initial, v);
        System.out.println(time);
        
        scanner.close();
    }
    
    static int bfs(List<List<Integer>> graph, int[] initial, int v) {
        boolean[] filled = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        int time = -1;
        
        for (int i = 0; i < v; i++) {
            if (initial[i] == 1) {
                filled[i] = true;
                queue.add(i);
            }
        }
        
        if (queue.isEmpty()) return -1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                
                for (int neighbor : graph.get(node)) {
                    if (!filled[neighbor]) {
                        filled[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
            
            if (!queue.isEmpty()) time++;
        }
        
        for (int i = 0; i < v; i++) {
            if (!filled[i]) return -1;
        }
        
        return time + 1;
    }
}
