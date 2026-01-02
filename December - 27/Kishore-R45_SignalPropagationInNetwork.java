import java.util.*;

public class SignalPropagationInNetwork {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int x=0; x<n; x++) adj.add(new ArrayList<>());
        
        for(int x=0; x<m; x++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int delay = sc.nextInt();
            adj.get(from).add(new int[]{to, delay});
        }
        
        int src = sc.nextInt();
        
        int[] time = new int[n];
        for(int x=0; x<n; x++) time[x] = Integer.MAX_VALUE;
        time[src] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{src, 0});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int t = cur[1];
            
            if(t > time[node]) continue;
            
            for(int[] edge : adj.get(node)){
                int next = edge[0];
                int cost = edge[1];
                
                if(time[node] + cost < time[next]){
                    time[next] = time[node] + cost;
                    pq.add(new int[]{next, time[next]});
                }
            }
        }
        
        int maxDelay = 0;
        for(int x=0; x<n; x++){
            if(time[x] == Integer.MAX_VALUE){
                System.out.println(-1);
                return;
            }
            if(time[x] > maxDelay) maxDelay = time[x];
        }
        
        System.out.println(maxDelay);
        sc.close();
    }
}
