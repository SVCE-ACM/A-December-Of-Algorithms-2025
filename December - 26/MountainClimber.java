package Dec26;
import java.util.*;
public class MountainClimber {
    static int m, n;
    static int[][] grid;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int dfs(int x, int y) {
        if (dp[x][y] != 0)
            return dp[x][y];

        int maxPath = 1;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < m && ny < n &&
                    grid[nx][ny] > grid[x][y]) {

                maxPath = Math.max(maxPath, 1 + dfs(nx, ny));
            }
        }

        dp[x][y] = maxPath;
        return maxPath;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        grid = new int[m][n];
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, dfs(i, j));
            }
        }
        System.out.println(answer);
        sc.close();
    }
}
