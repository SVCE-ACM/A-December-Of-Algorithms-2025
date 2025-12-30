import java.util.*;

public class Day05_IslandCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int[][] g = new int[R][C];
        for (int i = 0; i < R; i++) for (int j = 0; j < C; j++) g[i][j] = sc.nextInt();
        int cnt = 0;
        boolean[][] vis = new boolean[R][C];
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        for (int i = 0; i < R; i++) for (int j = 0; j < C; j++) if (!vis[i][j] && g[i][j]==1) {
            cnt++;
            Deque<int[]> dq = new ArrayDeque<>(); dq.add(new int[]{i,j}); vis[i][j]=true;
            while(!dq.isEmpty()){
                int[] p = dq.poll();
                for(int k=0;k<4;k++){int nr=p[0]+dr[k], nc=p[1]+dc[k];
                    if(nr>=0&&nr<R&&nc>=0&&nc<C&&!vis[nr][nc]&&g[nr][nc]==1){vis[nr][nc]=true;dq.add(new int[]{nr,nc});}
                }
            }
        }
        System.out.println(cnt);
        sc.close();
    }
}
