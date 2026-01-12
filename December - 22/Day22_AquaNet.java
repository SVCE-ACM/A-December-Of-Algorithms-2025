import java.util.*;

public class Day22_AquaNet {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt(), E=sc.nextInt();
        List<Integer>[] g=new List[V]; for(int i=0;i<V;i++) g[i]=new ArrayList<>();
        for(int i=0;i<E;i++){int u=sc.nextInt(), v=sc.nextInt(); g[u].add(v); g[v].add(u);} 
        int[] state=new int[V]; for(int i=0;i<V;i++) state[i]=sc.nextInt();
        Deque<int[]> dq=new ArrayDeque<>(); boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++) if(state[i]==1){dq.add(new int[]{i,0}); vis[i]=true;}
        int minutes=0; int filled=0; for(int i=0;i<V;i++) if(state[i]==1) filled++;
        while(!dq.isEmpty()){
            int[] p=dq.poll(); int u=p[0], t=p[1]; minutes=Math.max(minutes,t);
            for(int w: g[u]) if(!vis[w]){vis[w]=true; dq.add(new int[]{w,t+1}); filled++;}
        }
        System.out.println(filled==V?minutes:-1); sc.close();
    }
}
