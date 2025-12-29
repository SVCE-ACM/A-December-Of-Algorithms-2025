import java.util.*;

public class Magesh2424_TreasureHuntInLockedMaze {

    static class State {
        int r, c, mask, dist;

        State(int r, int c, int mask, int dist) {
            this.r = r;
            this.c = c;
            this.mask = mask;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read dimensions
        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine(); // consume newline

        char[][] grid = new char[M][N];
        int sr = -1, scCol = -1;

        // Read grid
        for (int i = 0; i < M; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j);
                if (grid[i][j] == 'S') {
                    sr = i;
                    scCol = j;
                }
            }
        }

        // Directions: up, down, left, right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // visited[row][col][keysMask]
        boolean[][][] visited = new boolean[M][N][1 << 10];

        Queue<State> q = new LinkedList<>();
        q.offer(new State(sr, scCol, 0, 0));
        visited[sr][scCol][0] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();

            // Reached treasure
            if (grid[cur.r][cur.c] == 'T') {
                System.out.println(cur.dist);
                sc.close();
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nr >= M || nc < 0 || nc >= N) continue;

                char cell = grid[nr][nc];
                if (cell == '#') continue; // wall

                int newMask = cur.mask;

                // Key
                if (cell >= 'a' && cell <= 'j') {
                    newMask |= (1 << (cell - 'a'));
                }

                // Door
                if (cell >= 'A' && cell <= 'J') {
                    int keyBit = 1 << (cell - 'A');
                    if ((cur.mask & keyBit) == 0) continue; // key not present
                }

                if (!visited[nr][nc][newMask]) {
                    visited[nr][nc][newMask] = true;
                    q.offer(new State(nr, nc, newMask, cur.dist + 1));
                }
            }
        }

        // Treasure unreachable
        System.out.println(-1);
        sc.close();
    }
}
