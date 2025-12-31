package Dec25;
import java.util.*;
        public class TreasureHunt {

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

                int m = sc.nextInt();
                int n = sc.nextInt();
                sc.nextLine();

                char[][] grid = new char[m][n];
                int startR = 0, startC = 0;

                for (int i = 0; i < m; i++) {
                    grid[i] = sc.nextLine().toCharArray();
                    for (int j = 0; j < n; j++) {
                        if (grid[i][j] == 'S') {
                            startR = i;
                            startC = j;
                        }
                    }
                }

                System.out.println(bfs(grid, m, n, startR, startC));
            }

            static int bfs(char[][] grid, int m, int n, int sr, int sc) {

                int[] dr = {1, -1, 0, 0};
                int[] dc = {0, 0, 1, -1};

                boolean[][][] visited = new boolean[m][n][1 << 10];
                Queue<State> q = new LinkedList<>();

                q.add(new State(sr, sc, 0, 0));
                visited[sr][sc][0] = true;

                while (!q.isEmpty()) {
                    State cur = q.poll();

                    if (grid[cur.r][cur.c] == 'T') {
                        return cur.steps;
                    }

                    for (int i = 0; i < 4; i++) {
                        int nr = cur.r + dr[i];
                        int nc = cur.c + dc[i];
                        int keys = cur.keys;

                        if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                        char ch = grid[nr][nc];

                        if (ch == '#') continue;

                        // Key
                        if (ch >= 'a' && ch <= 'j') {
                            keys |= (1 << (ch - 'a'));
                        }

                        // Door
                        if (ch >= 'A' && ch <= 'J') {
                            if ((keys & (1 << (ch - 'A'))) == 0) continue;
                        }

                        if (!visited[nr][nc][keys]) {
                            visited[nr][nc][keys] = true;
                            q.add(new State(nr, nc, keys, cur.steps + 1));
                        }
                    }
                }
                return -1;
            }
        }