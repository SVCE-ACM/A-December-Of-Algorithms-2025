import java.util.Scanner;
public class MonishmakerIslandCounter{
    static int R;
    static int C;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void dfs(int r, int c){
        visited[r][c] = true;

        for(int i=0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if( nr>=0 && nr<R && nc>=0 && nc<C && grid[nr][nc]==1 && !visited[nr][nc]){
                dfs(nr,nc);
            }
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        grid = new int[R][C];
        visited = new boolean[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int islands = 0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i][j] == 1  && !visited[i][j]){
                    islands ++;
                    dfs(i,j);
                }
            }
        }
        System.out.println(islands);
    }
}