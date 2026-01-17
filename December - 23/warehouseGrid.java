package Dec23;
import java.util.*;
    public class warehouseGrid {
        static class Cell {
            int row, col, dist;
            Cell(int r, int c, int d) {
                row = r;
                col = c;
                dist = d;
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
            if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
                System.out.println(-1);
                return;
            }

            boolean[][] visited = new boolean[m][n];
            Queue<Cell> queue = new LinkedList<>();

            // Directions: up, down, left, right
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};

            queue.offer(new Cell(0, 0, 0));
            visited[0][0] = true;

            while (!queue.isEmpty()) {
                Cell curr = queue.poll();

                // Reached destination
                if (curr.row == m - 1 && curr.col == n - 1) {
                    System.out.println(curr.dist);
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int nr = curr.row + dr[i];
                    int nc = curr.col + dc[i];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
                            grid[nr][nc] == 0 && !visited[nr][nc]) {

                        visited[nr][nc] = true;
                        queue.offer(new Cell(nr, nc, curr.dist + 1));
                    }
                }
            }
            System.out.println(-1);
        }
    }

