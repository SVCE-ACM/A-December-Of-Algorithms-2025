import java.util.Scanner;

public class IslandCounter {

    static int R, C;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        grid = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int islandCount = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    islandCount++;
                    dfs(i, j); 
                }
            }
        }

        System.out.println(islandCount);
        sc.close();
    }
    static void dfs(int i, int j) {
        
        if (i < 0 || i >= R || j < 0 || j >= C || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        dfs(i + 1, j); // down
        dfs(i - 1, j); // up
        dfs(i, j + 1); // right
        dfs(i, j - 1); // left
    }
}
