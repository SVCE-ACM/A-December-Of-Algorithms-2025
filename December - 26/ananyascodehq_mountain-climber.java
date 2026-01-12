/*
 * Problem: Longest Strictly Increasing Path in a Matrix
 *
 * Key Idea:
 * ---------
 * From each cell, you can move up/down/left/right only if the next cell
 * has a STRICTLY greater value.
 *
 * Brute Force DFS from each cell = O((MN) * 4^(MN)) → impossible.
 *
 * Optimization:
 * -------------
 * Use DFS + Memoization (Top Down DP)
 *
 * dp[r][c] = length of longest increasing path starting from (r,c)
 *
 * For each cell:
 * Try moving in 4 directions → take max increasing path.
 * Store result → reuse later.
 *
 * Complexity:
 * -----------
 * Time  : O(M * N)
 * Space : O(M * N) recursion + memo
 */

import java.util.*;

public class Main {

    static int[][] grid;
    static int[][] dp;
    static int M, N;

    // Directions: up, down, left, right
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        grid = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                grid[i][j] = sc.nextInt();

        int ans = 0;

        // Compute longest path starting from every cell
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                ans = Math.max(ans, dfs(i, j));

        System.out.println(ans);
    }

    private static int dfs(int r, int c) {
        // Already computed → reuse
        if (dp[r][c] != 0) return dp[r][c];

        int best = 1; // At least the cell itself

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            // Boundary + strictly increasing check
            if (nr >= 0 && nr < M && nc >= 0 && nc < N &&
                    grid[nr][nc] > grid[r][c]) {
                best = Math.max(best, 1 + dfs(nr, nc));
            }
        }

        return dp[r][c] = best;
    }
}
