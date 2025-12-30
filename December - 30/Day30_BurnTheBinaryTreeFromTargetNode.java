import java.util.*;

public class Day30_BurnTheBinaryTreeFromTargetNode {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] vals=new int[n]; for(int i=0;i<n;i++) vals[i]=sc.nextInt();
        List<Integer>[] g=new List[n]; for(int i=0;i<n;i++) g[i]=new ArrayList<>();
        for(int i=0;i<n-1;i++){int u=sc.nextInt(), v=sc.nextInt(); g[u].add(v); g[v].add(u);} int targetVal=sc.nextInt();
        int start=-1; for(int i=0;i<n;i++) if(vals[i]==targetVal) {start=i; break;} if(start==-1){System.out.println(); sc.close(); return;}
        boolean[] vis=new boolean[n]; Deque<Integer> dq=new ArrayDeque<>(); dq.add(start); vis[start]=true;
        while(!dq.isEmpty()){ int sz=dq.size(); StringJoiner sj=new StringJoiner(", "); for(int i=0;i<sz;i++){int u=dq.poll(); sj.add(String.valueOf(vals[u])); for(int v: g[u]) if(!vis[v]){vis[v]=true; dq.add(v);} } System.out.println(sj.toString()); }
        sc.close();
    }
}
