import java.util.Scanner;

public class java_DhanaAnjana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        
        int[][] grid = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        
        boolean[][] visited = new boolean[r][c];
        int islandCount = 0;
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j, r, c);
                    islandCount++;
                }
            }
        }
        
        System.out.println(islandCount);
        scanner.close();
    }
    
    static void dfs(int[][] grid, boolean[][] visited, int i, int j, int r, int c) {
        if (i < 0 || i >= r || j < 0 || j >= c || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        
        visited[i][j] = true;
        
        dfs(grid, visited, i + 1, j, r, c);
        dfs(grid, visited, i - 1, j, r, c);
        dfs(grid, visited, i, j + 1, r, c);
        dfs(grid, visited, i, j - 1, r, c);
    }
}
