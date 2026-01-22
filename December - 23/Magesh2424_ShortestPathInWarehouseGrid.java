import java.util.*;

public class Magesh2424_ShortestPathInWarehouseGrid {

    static class Cell {
        int row, col, dist;

        Cell(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read grid dimensions
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];

        // Read grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // If start or end is blocked
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            System.out.println(-1);
            sc.close();
            return;
        }

        boolean[][] visited = new boolean[m][n];
        Queue<Cell> queue = new LinkedList<>();

        // Directions: up, down, left, right
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // Start BFS
        queue.offer(new Cell(0, 0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Cell curr = queue.poll();

            // Destination reached
            if (curr.row == m - 1 && curr.col == n - 1) {
                System.out.println(curr.dist);
                sc.close();
                return;
            }

            // Explore neighbors
            for (int d = 0; d < 4; d++) {
                int nr = curr.row + dx[d];
                int nc = curr.col + dy[d];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
                        grid[nr][nc] == 0 && !visited[nr][nc]) {

                    visited[nr][nc] = true;
                    queue.offer(new Cell(nr, nc, curr.dist + 1));
                }
            }
        }

        // Destination not reachable
        System.out.println(-1);
        sc.close();
    }
}
