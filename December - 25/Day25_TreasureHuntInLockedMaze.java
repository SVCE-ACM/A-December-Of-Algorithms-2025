import java.util.*;

public class Day25_TreasureHuntInLockedMaze {
    static class State{int r,c,keys,dist; State(int r,int c,int k,int d){this.r=r;this.c=c;this.keys=k;this.dist=d;}} 
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int M=sc.nextInt(), N=sc.nextInt(); sc.nextLine(); char[][] g=new char[M][N]; int sr=0, scp=0;
        for(int i=0;i<M;i++){ String line=sc.nextLine(); for(int j=0;j<N;j++){g[i][j]=line.charAt(j); if(g[i][j]=='S'){sr=i;scp=j;}}}
        boolean[][][] vis=new boolean[M][N][1<<10]; Deque<State> dq=new ArrayDeque<>(); dq.add(new State(sr,scp,0,0)); vis[sr][scp][0]=true;
        int[] dr={1,-1,0,0}, dc={0,0,1,-1};
        while(!dq.isEmpty()){ State s=dq.poll(); if(g[s.r][s.c]=='T'){System.out.println(s.dist); sc.close(); return;} for(int k=0;k<4;k++){int nr=s.r+dr[k], nc=s.c+dc[k]; if(nr<0||nr>=M||nc<0||nc>=N) continue; char ch=g[nr][nc]; if(ch=='#') continue; int nk=s.keys; if(ch>='a'&&ch<='j') nk |= 1<<(ch-'a'); if(ch>='A'&&ch<='J'){ if((nk & (1<<(ch-'A')))==0) continue; } if(!vis[nr][nc][nk]){vis[nr][nc][nk]=true; dq.add(new State(nr,nc,nk,s.dist+1));}} }
        System.out.println(-1); sc.close();
    }
}
