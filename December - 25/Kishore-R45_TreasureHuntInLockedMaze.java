import java.util.*;

public class TreasureHuntInLockedMaze {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();
        
        char[][] maze = new char[rows][cols];
        int startR = 0, startC = 0;
        
        for(int x=0; x<rows; x++){
            String line = sc.nextLine();
            for(int y=0; y<cols; y++){
                maze[x][y] = line.charAt(y);
                if(maze[x][y] == 'S'){
                    startR = x;
                    startC = y;
                }
            }
        }
        
        HashMap<String, Integer> visited = new HashMap<>();
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{startR, startC, 0, 0});
        visited.put(startR + "-" + startC + "-" + 0, 0);
        
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        
        while(!q.isEmpty()){
            int[] cur = q.removeFirst();
            int r = cur[0], c = cur[1];
            int keys = cur[2], dist = cur[3];
            
            if(maze[r][c] == 'T'){
                System.out.println(dist);
                return;
            }
            
            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                int newKeys = keys;
                
                if(nr<0 || nr>=rows || nc<0 || nc>=cols) continue;
                if(maze[nr][nc] == '#') continue;
                
                char cell = maze[nr][nc];
                
                if(cell >= 'A' && cell <= 'J'){
                    int need = 1 << (cell - 'A');
                    if((keys & need) == 0) continue;
                }
                
                if(cell >= 'a' && cell <= 'j'){
                    newKeys = keys | (1 << (cell - 'a'));
                }
                
                String state = nr + "-" + nc + "-" + newKeys;
                if(!visited.containsKey(state) || visited.get(state) > dist + 1){
                    visited.put(state, dist + 1);
                    q.add(new int[]{nr, nc, newKeys, dist + 1});
                }
            }
        }
        
        System.out.println(-1);
        sc.close();
    }
}
