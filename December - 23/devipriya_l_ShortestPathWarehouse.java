import java.util.*;

public class devipriya_l_ShortestPathWarehouse {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) {
            System.out.println(-1);
            return;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        q.add(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], d = cur[2];

            if (r == m-1 && c == n-1) {
                System.out.println(d);
                return;
            }

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
                    !visited[nr][nc] && grid[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc, d + 1});
                }
            }
        }
        System.out.println(-1);
    }
}
