import java.util.*;

public class devipriya_l_MountainClimber {

    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    static int[][] dp;
    static int M, N;

    public static int dfs(int[][] grid, int r, int c) {
        if (dp[r][c] != 0) return dp[r][c];

        int best = 1;
        for (int[] d : dirs) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < M && nc >= 0 && nc < N &&
                grid[nr][nc] > grid[r][c]) {
                best = Math.max(best, 1 + dfs(grid, nr, nc));
            }
        }
        dp[r][c] = best;
        return best;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        int[][] grid = new int[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                grid[i][j] = sc.nextInt();

        dp = new int[M][N];
        int ans = 0;

        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                ans = Math.max(ans, dfs(grid, i, j));

        System.out.println(ans);
    }
}
