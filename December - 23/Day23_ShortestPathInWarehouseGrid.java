import java.util.*;

public class Day23_ShortestPathInWarehouseGrid {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt(), n=sc.nextInt(); int[][] g=new int[m][n]; for(int i=0;i<m;i++) for(int j=0;j<n;j++) g[i][j]=sc.nextInt();
        int[][] dist=new int[m][n]; for(int[] r:dist) Arrays.fill(r,-1);
        int[] dr={1,-1,0,0}, dc={0,0,1,-1};
        Deque<int[]> dq=new ArrayDeque<>(); if(g[0][0]==0){dq.add(new int[]{0,0}); dist[0][0]=0;} else {System.out.println(-1); sc.close(); return;}
        while(!dq.isEmpty()){int[] p=dq.poll(); int r=p[0], c=p[1]; for(int k=0;k<4;k++){int nr=r+dr[k], nc=c+dc[k]; if(nr>=0&&nr<m&&nc>=0&&nc<n&&g[nr][nc]==0&&dist[nr][nc]==-1){dist[nr][nc]=dist[r][c]+1; dq.add(new int[]{nr,nc});}}}
        System.out.println(dist[m-1][n-1]); sc.close();
    }
}
