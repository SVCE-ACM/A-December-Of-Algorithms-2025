import java.util.*;

public class Main {

    // Helper class to store a cell's row, col and distance from start
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

        // Input grid dimensions
        int m = sc.nextInt();
        int n = sc.nextInt();

        // Read grid
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        // Print result
        System.out.println(shortestPath(grid, m, n));
    }

    /**
     * Shortest Path in Warehouse Grid (BFS)
     *
     * Algorithm:
     * 1. If start or end cell is blocked → unreachable → return -1
     * 2. Use BFS because grid is unweighted and BFS guarantees shortest path
     * 3. Maintain a visited matrix to avoid revisiting cells
     * 4. BFS queue stores: row, column, distance from start
     * 5. When destination is reached → return distance
     * 6. If BFS finishes without reaching destination → unreachable → return -1
     *
     * Time Complexity:  O(m * n)
     * Space Complexity: O(m * n)
     */
    private static int shortestPath(int[][] grid, int m, int n) {

        // If start or end is blocked → impossible
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1)
            return -1;

        // Visited array to prevent reprocessing cells
        boolean[][] visited = new boolean[m][n];

        // BFS queue
        Queue<Cell> q = new LinkedList<>();
        q.offer(new Cell(0, 0, 0));  // start at (0,0) with distance 0
        visited[0][0] = true;

        // 4-directional movement: DOWN, UP, RIGHT, LEFT
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        // BFS traversal
        while (!q.isEmpty()) {
            Cell cur = q.poll();

            // If we reached destination → return distance
            if (cur.r == m - 1 && cur.c == n - 1)
                return cur.dist;

            // Explore all 4 directions
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                // Check boundaries + ensure walkable cell + not visited before
                if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
                        grid[nr][nc] == 0 && !visited[nr][nc]) {

                    visited[nr][nc] = true;
                    q.offer(new Cell(nr, nc, cur.dist + 1));
                }
            }
        }

        // If BFS completes without reaching target → unreachable
        return -1;
    }
}
