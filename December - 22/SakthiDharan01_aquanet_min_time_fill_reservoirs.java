import java.util.*;

public class SakthiDharan01_aquanet_min_time_fill_reservoirs {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int V = sc.nextInt();
        if (!sc.hasNextInt()) return;
        int E = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0;i<V;i++) adj.add(new ArrayList<>());
        for (int i=0;i<E;i++){
            if (!sc.hasNextInt()) break;
            int u = sc.nextInt();
            if (!sc.hasNextInt()) break;
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] init = new int[V];
        for (int i=0;i<V && sc.hasNextInt();i++) init[i]=sc.nextInt();
        int[] dist = new int[V];
        Arrays.fill(dist, -1);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i=0;i<V;i++){
            if (init[i]==1){
                dist[i]=0; q.add(i);
            }
        }
        if (q.isEmpty()) {System.out.println(-1); return;}
        while (!q.isEmpty()){
            int u = q.poll();
            for (int nb : adj.get(u)){
                if (dist[nb]==-1){
                    dist[nb]=dist[u]+1;
                    q.add(nb);
                }
            }
        }
        int ans = 0;
        for (int d: dist){
            if (d==-1){System.out.println(-1); sc.close(); return;}
            ans = Math.max(ans, d);
        }
        System.out.println(ans);
        sc.close();
    }
}
