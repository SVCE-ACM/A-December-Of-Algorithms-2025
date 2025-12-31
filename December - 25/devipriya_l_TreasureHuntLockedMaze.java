import java.util.*;

public class devipriya_l_TreasureHuntLockedMaze {
    static class State {
        int r, c, keys, steps;
        State(int r, int c, int keys, int steps) {
            this.r = r; this.c = c; this.keys = keys; this.steps = steps;
        }
    }
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();
        char[][] grid = new char[M][N];
        int sr = 0, scn = 0;

        for (int i = 0; i < M; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = row.charAt(j);
                if (grid[i][j] == 'S') {
                    sr = i;
                    scn = j;
                }
            }
        }

        boolean[][][] visited = new boolean[M][N][1 << 10];
        Queue<State> q = new LinkedList<>();
        q.add(new State(sr, scn, 0, 0));
        visited[sr][scn][0] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            if (grid[cur.r][cur.c] == 'T') {
                System.out.println(cur.steps);
                return;
            }

            for (int k = 0; k < 4; k++) {
                int nr = cur.r + dr[k], nc = cur.c + dc[k];
                int keys = cur.keys;

                if (nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
                char ch = grid[nr][nc];
                if (ch == '#') continue;

                if (ch >= 'A' && ch <= 'J') {
                    if ((keys & (1 << (ch - 'A'))) == 0) continue;
                }

                if (ch >= 'a' && ch <= 'j') {
                    keys |= (1 << (ch - 'a'));
                }

                if (!visited[nr][nc][keys]) {
                    visited[nr][nc][keys] = true;
                    q.add(new State(nr, nc, keys, cur.steps + 1));
                }
            }
        }
        System.out.println(-1);
    }
}
