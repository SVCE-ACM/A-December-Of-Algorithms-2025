import java.util.*;

public class MinimumWeightCycleInGraph {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int x=0; x<v; x++) adj.add(new ArrayList<>());
        
        int[][] edgeList = new int[e][3];
        for(int x=0; x<e; x++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            edgeList[x] = new int[]{a, b, w};
            adj.get(a).add(new int[]{b, w});
            adj.get(b).add(new int[]{a, w});
        }
        
        int minCycle = Integer.MAX_VALUE;
        
        for(int[] edge : edgeList){
            int u = edge[0];
            int w = edge[1];
            int wt = edge[2];
            
            int[] dist = new int[v];
            for(int x=0; x<v; x++) dist[x] = Integer.MAX_VALUE;
            dist[u] = 0;
            
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
            pq.add(new int[]{u, 0});
            
            while(!pq.isEmpty()){
                int[] cur = pq.poll();
                int node = cur[0];
                int d = cur[1];
                
                if(d > dist[node]) continue;
                
                for(int[] nb : adj.get(node)){
                    int next = nb[0];
                    int cost = nb[1];
                    
                    if(node == u && next == w) continue;
                    if(node == w && next == u) continue;
                    
                    if(dist[node] + cost < dist[next]){
                        dist[next] = dist[node] + cost;
                        pq.add(new int[]{next, dist[next]});
                    }
                }
            }
            
            if(dist[w] != Integer.MAX_VALUE){
                int cycleWeight = dist[w] + wt;
                if(cycleWeight < minCycle) minCycle = cycleWeight;
            }
        }
        
        if(minCycle == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(minCycle);
        }
        sc.close();
    }
}
