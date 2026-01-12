/*
 * Problem: Treasure Hunt in Locked Maze
 *
 * Maze Legend:
 * ------------
 * S = Start Position
 * T = Treasure / Goal
 * . = Open path
 * # = Wall / Block
 * a–j = Keys
 * A–J = Doors (require corresponding key)
 *
 * Objective:
 * ----------
 * Find MINIMUM number of steps to reach T from S.
 * You may move UP / DOWN / LEFT / RIGHT.
 * Must collect required keys to unlock doors.
 * Return -1 if treasure is unreachable.
 *
 * Core Idea (Graph + State BFS):
 * ------------------------------
 * This is NOT a normal BFS because visiting a cell again
 * WITH different keys is a different state.
 *
 * So our BFS state is:
 *      (row, col, keyMask)
 *
 * keyMask:
 * --------
 * Bitmask of 10 bits -> represents which keys we currently hold.
 * If we pick up 'a', we set bit 0.
 * If we pick up 'b', set bit 1.
 * ...
 * If we pick up 'j', set bit 9.
 *
 * Visiting Control:
 * -----------------
 * visited[row][col][keyMask]
 * Ensures we don't revisit same cell with same key state (prevents infinite loops)
 *
 * Transition Rules:
 * -----------------
 * Can't cross wall '#'
 * If cell contains DOOR (A–J):
 *      ✔ Only proceed if corresponding key bit is set
 * If cell contains KEY (a–j):
 *      ✔ Update keyMask using OR bit operation
 *
 * Stopping Condition:
 * -------------------
 * When we first reach 'T' → return BFS distance
 *
 * Complexity:
 * -----------
 * Time  : O(M * N * 2^K)  (K ≤ 10, grid ≤ 30x30 → fully safe)
 * Space : O(M * N * 2^K)
 */

import java.util.*;

public class Main {

    // Represent each BFS state
    static class State {
        int r;      // row
        int c;      // column
        int keys;   // bitmask of collected keys
        int dist;   // distance travelled

        State(int r, int c, int keys, int dist) {
            this.r = r;
            this.c = c;
            this.keys = keys;
            this.dist = dist;
        }
    }

    static int M, N;
    static char[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        sc.nextLine();  // consume newline

        grid = new char[M][N];

        int startR = 0, startC = 0;

        // Read maze + locate start
        for (int i = 0; i < M; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = row.charAt(j);
                if (grid[i][j] == 'S') {
                    startR = i;
                    startC = j;
                }
            }
        }

        System.out.println(bfs(startR, startC));
    }

    private static int bfs(int sr, int sc) {

        // visited[row][col][keyMask]
        boolean[][][] visited = new boolean[M][N][1 << 10];

        Queue<State> q = new LinkedList<>();
        q.offer(new State(sr, sc, 0, 0));
        visited[sr][sc][0] = true;

        // 4-directional movement
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            State cur = q.poll();

            // If treasure found → answer!
            if (grid[cur.r][cur.c] == 'T')
                return cur.dist;

            // Explore neighbors
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                int keys = cur.keys;

                // Boundary check
                if (nr < 0 || nr >= M || nc < 0 || nc >= N) continue;

                char cell = grid[nr][nc];

                // Wall check
                if (cell == '#') continue;

                // Door check (A–J)
                if (cell >= 'A' && cell <= 'J') {
                    int doorIndex = cell - 'A';

                    // If we don't have corresponding key → cannot enter
                    if ((keys & (1 << doorIndex)) == 0)
                        continue;
                }

                // Key pickup check (a–j)
                if (cell >= 'a' && cell <= 'j') {
                    int keyIndex = cell - 'a';
                    keys = keys | (1 << keyIndex);   // add key using OR
                }

                // Avoid revisiting same state
                if (!visited[nr][nc][keys]) {
                    visited[nr][nc][keys] = true;
                    q.offer(new State(nr, nc, keys, cur.dist + 1));
                }
            }
        }

        // If BFS exhausts → treasure unreachable
        return -1;
    }
}
