import java.util.*;

public class WarehouseShortestPath {

    static class Cell {
        int r, c, dist;
        Cell(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(shortestPath(grid, m, n));
        sc.close();
    }

    static int shortestPath(int[][] grid, int m, int n) {

        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }

        boolean[][] visited = new boolean[m][n];
        Queue<Cell> queue = new LinkedList<>();

        // Start BFS
        queue.add(new Cell(0, 0, 0));
        visited[0][0] = true;

        int[] dr = {1, -1, 0, 0}; 
        int[] dc = {0, 0, 1, -1}; 

        while (!queue.isEmpty()) {
            Cell curr = queue.poll();

            if (curr.r == m - 1 && curr.c == n - 1) {
                return curr.dist;
            }

            for (int k = 0; k < 4; k++) {
                int nr = curr.r + dr[k];
                int nc = curr.c + dc[k];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
                        grid[nr][nc] == 0 && !visited[nr][nc]) {

                    visited[nr][nc] = true;
                    queue.add(new Cell(nr, nc, curr.dist + 1));
                }
            }
        }

        return -1; 
    }
}
