import java.util.*;
public class MonishmakerMinimumWeightCycle {
    static class Edge{
        int to,weight;
        Edge(int t,int w){
            to = t;
            weight = w;
        }
    }
    static final int INF = (int)1e9;
    public static int dijkstra(int n,List<List<Edge>> graph,int src,int dest){
        int[] dist = new int[n];;
        Arrays.fill(dist,INF);
        dist[src] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        pq.add(new int[]{src,0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0],d = curr[1];
            if(node == dest) return d;
            if(d>dist[node]) continue;

            for(Edge e : graph.get(node)){
                if(dist[e.to] > d+e.weight){
                    dist[e.to] = d+e.weight;
                    pq.add(new int[]{e.to,dist[e.to]}); 
                }
            }
        }
        return INF;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<int[]> edges = new ArrayList<>();
        List<List<Edge>> graph = new ArrayList<>();  

        for(int i=0;i<n;i++) graph.add(new ArrayList<>());

        for(int i=0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new int[]{u,v,w});
            graph.get(u).add(new Edge(v,w));
            graph.get(v).add(new Edge(u,w));
        }
        int ans = INF;

        for(int[] e: edges){
            int u = e[0], v= e[1], w= e[2];

            graph.get(u).removeIf(x->x.to == v && x.weight == w);
            graph.get(v).removeIf(x->x.to == u && x.weight == w);

            int dist = dijkstra(n, graph, u,v);
            if(dist != INF){
                ans = Math.min(ans,dist+w);
            }
            graph.get(u).add(new Edge(v,w));
            graph.get(v).add(new Edge(u,w));
        }
        System.out.println(ans == INF ?m-1 : ans);
    }
}
  