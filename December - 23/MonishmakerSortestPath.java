import java.util.*;
public class MonishmakerSortestPath {
    static class Cell{
        int r,c, dist;
        Cell(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    public static int sortestPath(int[][] grid,int m,int n){
        if(grid[0][0]==1 || grid[m-1][n-1]==1)
            return -1;
        boolean[][] visited = new boolean[m][n];
        Queue<Cell> q = new LinkedList<>();

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        q.offer(new Cell(0,0,0));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Cell curr = q.poll();

            if(curr.r == m-1 && curr.c == n-1)
                return curr.dist;

            for(int i=0;i<4;i++){
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 0 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.offer(new Cell(nr,nc,curr.dist+1));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] wareHouse = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                wareHouse[i][j] = sc.nextInt();
            }
        }
        System.out.println(sortestPath(wareHouse,r,c));
    }
}
