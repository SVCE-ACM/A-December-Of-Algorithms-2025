import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class java_DhanaAnjana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine(); 
        
        char[][] maze = new char[m][n];
        int startR = 0, startC = 0, targetR = 0, targetC = 0;
        
        for (int i = 0; i < m; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < line.length(); j++) {
                maze[i][j] = line.charAt(j);
                if (maze[i][j] == 'S') {
                    startR = i;
                    startC = j;
                } else if (maze[i][j] == 'T') {
                    targetR = i;
                    targetC = j;
                }
            }
        }
        
        int result = bfs(maze, startR, startC, targetR, targetC, m, n);
        System.out.println(result);
        
        scanner.close();
    }
    
    static int bfs(char[][] maze, int startR, int startC, int targetR, int targetC, int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.add(new int[]{startR, startC, 0, 0}); 
        visited.add(startR + "," + startC + "," + 0);
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int dist = current[2];
            int keys = current[3];
            
            if (row == targetR && col == targetC) {
                return dist;
            }
            
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    char cell = maze[newRow][newCol];
                    
                    if (cell == '#') continue;
                    
                    int newKeys = keys;
                    if (cell >= 'a' && cell <= 'j') {
                        newKeys |= (1 << (cell - 'a'));
                    }
                    
                    if (cell >= 'A' && cell <= 'J') {
                        if ((newKeys & (1 << (cell - 'A'))) == 0) {
                            continue;
                        }
                    }
                    
                    String state = newRow + "," + newCol + "," + newKeys;
                    if (!visited.contains(state)) {
                        visited.add(state);
                        queue.add(new int[]{newRow, newCol, dist + 1, newKeys});
                    }
                }
            }
        }
        
        return -1;
    }
}
