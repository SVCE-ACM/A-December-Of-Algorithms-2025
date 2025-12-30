import java.util.*;

public class Day27_SignalPropagationInANetwork {
    static class Edge{int v,w; Edge(int v,int w){this.v=v;this.w=w;}}
    public static void main(String[] args){ Scanner sc=new Scanner(System.in); int N=sc.nextInt(); int M=sc.nextInt(); List<Edge>[] g=new List[N]; for(int i=0;i<N;i++) g[i]=new ArrayList<>(); for(int i=0;i<M;i++){int u=sc.nextInt(), v=sc.nextInt(), t=sc.nextInt(); g[u].add(new Edge(v,t));} int S=sc.nextInt(); int[] dist=new int[N]; Arrays.fill(dist, Integer.MAX_VALUE); dist[S]=0; PriorityQueue<int[]>pq=new PriorityQueue<>(Comparator.comparingInt(x->x[0])); pq.add(new int[]{0,S}); while(!pq.isEmpty()){int[] p=pq.poll(); int d=p[0], u=p[1]; if(d!=dist[u]) continue; for(Edge e:g[u]) if(dist[e.v]>d+e.w){dist[e.v]=d+e.w; pq.add(new int[]{dist[e.v], e.v});}} int max=0; for(int i=0;i<N;i++){ if(dist[i]==Integer.MAX_VALUE){ System.out.println(-1); sc.close(); return; } max=Math.max(max, dist[i]); } System.out.println(max); sc.close(); }
}
