import java.util.*;

class Main {

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

        int count = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(count);
    }

    static void dfs(int r, int c) {
        if (r < 0 || c < 0 || r >= R || c >= C || grid[r][c] == 0) return;

        grid[r][c] = 0; // mark visited

        dfs(r + 1, c); // down
        dfs(r - 1, c); // up
        dfs(r, c + 1); // right
        dfs(r, c - 1); // left
    }
}
