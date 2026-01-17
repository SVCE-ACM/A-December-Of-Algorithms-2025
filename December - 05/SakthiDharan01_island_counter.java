import java.util.*;

public class SakthiDharan01_island_counter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int r = sc.nextInt();
        if (!sc.hasNextInt()) return;
        int c = sc.nextInt();
        int[][] grid = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (sc.hasNextInt()) grid[i][j] = sc.nextInt();
            }
        }
        boolean[][] vis = new boolean[r][c];
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                    ArrayDeque<int[]> dq = new ArrayDeque<>();
                    dq.add(new int[]{i,j});
                    vis[i][j] = true;
                    while (!dq.isEmpty()) {
                        int[] cur = dq.poll();
                        for (int[] d : dirs) {
                            int ni = cur[0] + d[0];
                            int nj = cur[1] + d[1];
                            if (ni>=0 && ni<r && nj>=0 && nj<c && !vis[ni][nj] && grid[ni][nj]==1) {
                                vis[ni][nj] = true;
                                dq.add(new int[]{ni,nj});
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
        sc.close();
    }
}
