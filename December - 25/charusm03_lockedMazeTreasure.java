import java.util.*;

public class charusm03_lockedMazeTreasure {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        char[][] grid = new char[M][N];
        int sx = -1, sy = -1;
        for (int i = 0; i < M; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j);
                if (grid[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
            }
        }
        System.out.println(minSteps(grid, sx, sy, M, N));
    }

    static int minSteps(char[][] grid, int sx, int sy, int M, int N) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[M][N][1 << 10];
        q.add(new int[] { sx, sy, 0, 0 });
        visited[sx][sy][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], keys = cur[2], steps = cur[3];

            if (grid[x][y] == 'T')
                return steps;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    char c = grid[nx][ny];
                    int newKeys = keys;
                    if (c == '#')
                        continue;
                    if (c >= 'a' && c <= 'j')
                        newKeys |= 1 << (c - 'a');
                    if (c >= 'A' && c <= 'J' && ((keys >> (c - 'A')) & 1) == 0)
                        continue;
                    if (!visited[nx][ny][newKeys]) {
                        visited[nx][ny][newKeys] = true;
                        q.add(new int[] { nx, ny, newKeys, steps + 1 });
                    }
                }
            }
        }
        return -1;
    }
}
