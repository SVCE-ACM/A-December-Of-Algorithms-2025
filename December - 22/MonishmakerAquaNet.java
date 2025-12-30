import java.util.*;

public class MonishmakerAquaNet {
    public static int minTimeToFill(int V,List<List<Integer>> graph,int[] water){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];

        for(int i=0;i<V;i++){
            if (water[i] == 1){
                q.offer(i);
                visited[i]=true;
            }
        }
        int minutes = -1;
        while(!q.isEmpty()){
            int size = q.size();
            minutes ++;
            for(int i=0;i<size;i++){
                int curr = q.poll();
                for(int nei : graph.get(curr)){
                    if(!visited[nei]){
                        visited[nei] = true;
                        q.offer(nei);
                    }
                }
            }
        }
        for(boolean v: visited){
            if(!v) return -1;
        }
        return minutes;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<V;i++) graph.add(new ArrayList<>());

        for(int i = 0;i<E;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int[] water = new int[V];
        for(int i=0;i<V;i++){
            water[i] = sc.nextInt(); 
        }
        System.out.println(minTimeToFill(V,graph,water));
    }
}
