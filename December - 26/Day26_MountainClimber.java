import java.util.*;

public class Day26_MountainClimber {
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    static int R,C; static int[][] a, memo;
    static int dfs(int r,int c){ if(memo[r][c]!=0) return memo[r][c]; int best=1; for(int[] d:dirs){int nr=r+d[0], nc=c+d[1]; if(nr>=0&&nr<R&&nc>=0&&nc<C && a[nr][nc]>a[r][c]) best=Math.max(best,1+dfs(nr,nc)); } return memo[r][c]=best; }
    public static void main(String[] args){ Scanner sc=new Scanner(System.in); R=sc.nextInt(); C=sc.nextInt(); a=new int[R][C]; for(int i=0;i<R;i++) for(int j=0;j<C;j++) a[i][j]=sc.nextInt(); memo=new int[R][C]; int ans=0; for(int i=0;i<R;i++) for(int j=0;j<C;j++) ans=Math.max(ans,dfs(i,j)); System.out.println(ans); sc.close(); }
}
