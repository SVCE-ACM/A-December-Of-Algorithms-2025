import java.util.Scanner;

public class LongestAscendingPath {

    static int M, N;
    static int[][] grid;
    static int[][] dp;

    static int[] dr = {1, -1, 0, 0}; 
    static int[] dc = {0, 0, 1, -1}; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        grid = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, dfs(i, j));
            }
        }

        System.out.println(answer);
        sc.close();
    }

    static int dfs(int r, int c) {

        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        int maxLen = 1; 

        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if (nr >= 0 && nr < M && nc >= 0 && nc < N &&
                grid[nr][nc] > grid[r][c]) {

                maxLen = Math.max(maxLen, 1 + dfs(nr, nc));
            }
        }

        dp[r][c] = maxLen;
        return maxLen;
    }
}
