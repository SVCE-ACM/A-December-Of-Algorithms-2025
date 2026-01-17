package Dec05;
import java.util.*;
public class IslandCounter {
        static int R, C;
        static int[][] grid;
        static boolean[][] visited;

        // Directions: up, down, left, right
        static int[] dx = {-1, 1, 0, 0};
        static int[] dy = {0, 0, -1, 1};

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            R = sc.nextInt();
            C = sc.nextInt();

            grid = new int[R][C];
            visited = new boolean[R][C];

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            int islandCount = 0;

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        islandCount++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(islandCount);
        }

        static void dfs(int x, int y) {
            visited[x][y] = true;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (grid[nx][ny] == 1 && !visited[nx][ny]) {
                        dfs(nx, ny);
                    }
                }
            }
        }
    }


