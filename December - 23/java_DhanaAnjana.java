import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class java_DhanaAnjana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        
        int distance = bfs(grid, m, n);
        System.out.println(distance);
        
        scanner.close();
    }
    
    static int bfs(int[][] grid, int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
        queue.add(new int[]{0, 0, 0});
        visited[0][0] = true;
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int dist = current[2];
            
            if (row == m - 1 && col == n - 1) {
                return dist;
            }
            
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                    !visited[newRow][newCol] && grid[newRow][newCol] == 0) {
                    visited[newRow][newCol] = true;
                    queue.add(new int[]{newRow, newCol, dist + 1});
                }
            }
        }
        
        return -1;
    }
}
