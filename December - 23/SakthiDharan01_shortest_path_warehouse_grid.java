import java.util.*;

public class SakthiDharan01_shortest_path_warehouse_grid {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int m = sc.nextInt();
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (sc.hasNextInt()) grid[i][j]=sc.nextInt();
            }
        }
        if (grid[0][0]==1 || grid[m-1][n-1]==1){
            System.out.println(-1);
            return;
        }
        int[][] dist = new int[m][n];
        for (int[] row: dist) Arrays.fill(row, -1);
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0});
        dist[0][0]=0;
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int x=cur[0], y=cur[1];
            if (x==m-1 && y==n-1){
                System.out.println(dist[x][y]);
                return;
            }
            for (int[] d: dirs){
                int nx = x+d[0], ny = y+d[1];
                if (nx>=0 && nx<m && ny>=0 && ny<n && grid[nx][ny]==0 && dist[nx][ny]==-1){
                    dist[nx][ny]=dist[x][y]+1;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        System.out.println(-1);
        sc.close();
    }
}
