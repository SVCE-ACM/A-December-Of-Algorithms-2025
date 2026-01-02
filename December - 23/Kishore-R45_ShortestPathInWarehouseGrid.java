import java.util.*;

public class ShortestPathInWarehouseGrid {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        
        int[][] grid = new int[rows][cols];
        for(int x=0; x<rows; x++){
            for(int y=0; y<cols; y++){
                grid[x][y] = sc.nextInt();
            }
        }
        
        if(grid[0][0] == 1 || grid[rows-1][cols-1] == 1){
            System.out.println(-1);
            return;
        }
        
        int[][] steps = new int[rows][cols];
        for(int[] row : steps) Arrays.fill(row, -1);
        steps[0][0] = 0;
        
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        
        while(!q.isEmpty()){
            int[] cur = q.removeFirst();
            int r = cur[0], c = cur[1];
            
            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if(nr>=0 && nr<rows && nc>=0 && nc<cols){
                    if(grid[nr][nc]==0 && steps[nr][nc]==-1){
                        steps[nr][nc] = steps[r][c] + 1;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
        
        System.out.println(steps[rows-1][cols-1]);
        sc.close();
    }
}
