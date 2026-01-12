import java.util.*;
public class MonishmakerSignalPropagation {
    static class Edge{
        int to,time;
        Edge(int to,int time){
            this.to = to;
            this.time = time;
        }
    }
    public static int networkDelayTime(int N,int M,int[][] links,int S){

        List<List<Edge>> graph = new ArrayList<>();
        for(int i=0;i<N;i++){
            graph.add(new ArrayList<>());  
        }
        for(int i=0;i<M;i++){
            int u = links[i][0];
            int v = links[i][1];
            int t = links[i][2];
            graph.get(u).add(new Edge(v,t));
        }
        int[] dist = new int[N];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[S] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));//Sort element baseed on time
        pq.offer(new int[]{0,S});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];

            if(time > dist[node]) continue;

            for(Edge e:graph.get(node)){
                if(dist[e.to] > time+e.time){
                    dist[e.to] = time + e.time;
                    pq.offer(new int[]{dist[e.to],e.to});
                }
            }
        }
        int maxTime = 0;
        for(int i=0;i<N;i++){
            if(dist[i]==Integer.MAX_VALUE)
                return -1;
            maxTime = Math.max(maxTime,dist[i]);
        }
        return maxTime;
    }
    public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    
    int[][] links = new int[M][3];
    for(int i=0;i<M;i++){
        links[i][0] = sc.nextInt();
        links[i][1] = sc.nextInt();
        links[i][2] = sc.nextInt();
    }
    int s = sc.nextInt();

    System.out.println(networkDelayTime(N, M, links, s));

    }
}
