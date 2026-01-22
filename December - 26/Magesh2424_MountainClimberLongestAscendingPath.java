import java.util.*;

public class Magesh2424_MountainClimberLongestAscendingPath {

    static int M, N;
    static int[][] grid;
    static int[][] dp;

    // Directions: up, down, left, right
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    // DFS with memoization
    static int dfs(int r, int c) {
        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        int maxLen = 1; // minimum path length is 1 (cell itself)

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < M && nc >= 0 && nc < N &&
                grid[nr][nc] > grid[r][c]) {

                maxLen = Math.max(maxLen, 1 + dfs(nr, nc));
            }
        }

        dp[r][c] = maxLen;
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read grid dimensions
        M = sc.nextInt();
        N = sc.nextInt();

        grid = new int[M][N];
        dp = new int[M][N];

        // Read grid heights
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int result = 0;

        // Compute longest ascending path starting from every cell
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                result = Math.max(result, dfs(i, j));
            }
        }

        // Output result
        System.out.println(result);

        sc.close();
    }
}
