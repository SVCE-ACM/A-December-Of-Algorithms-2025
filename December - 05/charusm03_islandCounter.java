import java.util.*;

public class charusm03_islandCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] grid = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                grid[i][j] = sc.nextInt();

        System.out.println(countIslands(grid));
    }

    public static int countIslands(int[][] grid) {
        int count = 0;
        int r = grid.length;
        int c = grid[0].length;

        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        int r = grid.length;
        int c = grid[0].length;

        if (i < 0 || j < 0 || i >= r || j >= c)
            return;

        if (grid[i][j] == 0 || visited[i][j])
            return;

        visited[i][j] = true;

        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);
    }
}
