import java.util.*;

public class TreasureHuntMaze {

    static class State {
        int r, c, keys, steps;
        State(int r, int c, int keys, int steps) {
            this.r = r;
            this.c = c;
            this.keys = keys;
            this.steps = steps;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();

        char[][] maze = new char[M][N];
        int sr = 0, scCol = 0;

        for (int i = 0; i < M; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                maze[i][j] = line.charAt(j);
                if (maze[i][j] == 'S') {
                    sr = i;
                    scCol = j;
                }
            }
        }

        System.out.println(minStepsToTreasure(maze, M, N, sr, scCol));
        sc.close();
    }

    static int minStepsToTreasure(char[][] maze, int M, int N, int sr, int sc) {

        boolean[][][] visited = new boolean[M][N][1 << 10];
        Queue<State> queue = new LinkedList<>();

        queue.add(new State(sr, sc, 0, 0));
        visited[sr][sc][0] = true;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            if (maze[cur.r][cur.c] == 'T') {
                return cur.steps;
            }

            for (int k = 0; k < 4; k++) {
                int nr = cur.r + dr[k];
                int nc = cur.c + dc[k];
                int newKeys = cur.keys;

                if (nr < 0 || nr >= M || nc < 0 || nc >= N) continue;

                char ch = maze[nr][nc];
                if (ch == '#') continue;
                if (ch >= 'a' && ch <= 'j') {
                    newKeys |= (1 << (ch - 'a'));
                }

                if (ch >= 'A' && ch <= 'J') {
                    if ((newKeys & (1 << (ch - 'A'))) == 0) {
                        continue;
                    }
                }

                if (!visited[nr][nc][newKeys]) {
                    visited[nr][nc][newKeys] = true;
                    queue.add(new State(nr, nc, newKeys, cur.steps + 1));
                }
            }
        }

        return -1;
    }
}
