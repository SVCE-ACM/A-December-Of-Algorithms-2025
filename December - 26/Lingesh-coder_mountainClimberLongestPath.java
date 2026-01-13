import java.util.*;

public class Lingesh-coder_mountainClimberLongestPath {
    static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] grid = new int[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                grid[i][j] = sc.nextInt();

        int[][] memo = new int[M][N];
        int res = 0;
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                res = Math.max(res, dfs(grid, i, j, memo));
        System.out.println(res);
    }

    static int dfs(int[][] grid, int i, int j, int[][] memo) {
        if (memo[i][j] != 0)
            return memo[i][j];
        int maxLen = 1;
        for (int[] d : dirs) {
            int ni = i + d[0], nj = j + d[1];
            if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] > grid[i][j]) {
                maxLen = Math.max(maxLen, 1 + dfs(grid, ni, nj, memo));
            }
        }
        memo[i][j] = maxLen;
        return maxLen;
    }
}
