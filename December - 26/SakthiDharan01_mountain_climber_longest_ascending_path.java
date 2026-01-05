import java.util.*;

public class SakthiDharan01_mountain_climber_longest_ascending_path {
    private static int m,n;
    private static int[][] grid;
    private static int[][] memo;
    private static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    private static int dfs(int x,int y){
        if (memo[x][y]!=0) return memo[x][y];
        int best = 1;
        for (int[] d: dirs){
            int nx = x+d[0], ny = y+d[1];
            if (nx>=0 && nx<m && ny>=0 && ny<n && grid[nx][ny] > grid[x][y]){
                best = Math.max(best, 1 + dfs(nx, ny));
            }
        }
        memo[x][y] = best;
        return best;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        m = sc.nextInt();
        if (!sc.hasNextInt()) return;
        n = sc.nextInt();
        grid = new int[m][n];
        memo = new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (sc.hasNextInt()) grid[i][j]=sc.nextInt();
            }
        }
        int ans = 0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                ans = Math.max(ans, dfs(i,j));
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
