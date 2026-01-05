import java.util.*;

public class SakthiDharan01_signal_propagation_network {
    private static class Edge {int to, w; Edge(int t,int w){this.to=t; this.w=w;}}

    private static class Node implements Comparable<Node>{
        int v; int dist;
        Node(int v,int d){this.v=v;this.dist=d;}
        public int compareTo(Node o){return Integer.compare(this.dist, o.dist);}    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        if (!sc.hasNextInt()) return;
        int m = sc.nextInt();
        List<List<Edge>> adj = new ArrayList<>();
        for (int i=0;i<n;i++) adj.add(new ArrayList<>());
        for (int i=0;i<m;i++){
            if (!sc.hasNextInt()) break;
            int u = sc.nextInt();
            if (!sc.hasNextInt()) break;
            int v = sc.nextInt();
            if (!sc.hasNextInt()) break;
            int w = sc.nextInt();
            adj.get(u).add(new Edge(v,w));
        }
        int source = sc.hasNextInt() ? sc.nextInt() : 0;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));
        while (!pq.isEmpty()){
            Node cur = pq.poll();
            if (cur.dist != dist[cur.v]) continue;
            for (Edge e : adj.get(cur.v)){
                int nd = cur.dist + e.w;
                if (nd < dist[e.to]){
                    dist[e.to] = nd;
                    pq.add(new Node(e.to, nd));
                }
            }
        }
        int max = 0;
        for (int d : dist){
            if (d == Integer.MAX_VALUE){
                System.out.println(-1);
                sc.close();
                return;
            }
            max = Math.max(max, d);
        }
        System.out.println(max);
        sc.close();
    }
}
