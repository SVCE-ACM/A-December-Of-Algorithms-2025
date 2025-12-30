import java.util.*;

public class Day29_MinimumWeightCycleInAGraph {
    static class Edge{int to,w; Edge(int t,int w){to=t;this.w=w;}}
    public static void main(String[] args){ Scanner sc=new Scanner(System.in); int V=sc.nextInt(); int E=sc.nextInt(); List<Edge>[] g=new List[V]; for(int i=0;i<V;i++) g[i]=new ArrayList<>(); List<int[]> edges=new ArrayList<>(); for(int i=0;i<E;i++){int u=sc.nextInt(), v=sc.nextInt(), w=sc.nextInt(); g[u].add(new Edge(v,w)); g[v].add(new Edge(u,w)); edges.add(new int[]{u,v,w});}
        long best = Long.MAX_VALUE;
        for(int[] e: edges){ int u=e[0], v=e[1], w=e[2];
            // dijkstra from u to v without direct edge u-v
            long[] dist=new long[V]; Arrays.fill(dist, Long.MAX_VALUE); PriorityQueue<long[]>pq=new PriorityQueue<>(Comparator.comparingLong(x->x[0])); dist[u]=0; pq.add(new long[]{0,u});
            while(!pq.isEmpty()){ long[] cur=pq.poll(); long d=cur[0]; int x=(int)cur[1]; if(d!=dist[x]) continue; for(Edge ed: g[x]){ if((x==u && ed.to==v && ed.w==w) || (x==v && ed.to==u && ed.w==w)) continue; if(dist[ed.to]>d+ed.w){dist[ed.to]=d+ed.w; pq.add(new long[]{dist[ed.to], ed.to});}} }
            if(dist[v]!=Long.MAX_VALUE) best=Math.min(best, dist[v]+w);
        }
        System.out.println(best==Long.MAX_VALUE?-1:best); sc.close(); }
}
