import java.util.Scanner;
public class MonishmakerMountainClimber{
    static int M,N;
    static int[][] grid;
    static int[][] dp;

    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};

    static int dfs(int x,int y){
        if(dp[x][y]!=0)
            return dp[x][y];

        int maxLen = 1;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < M && ny >= 0 && ny < N && grid[nx][ny]>grid[x][y]){
                maxLen = Math.max(maxLen, 1+dfs(nx,ny));
            }
        }
        dp[x][y] = maxLen;
        return maxLen; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        grid = new int[M][N];
        dp = new int[M][N]; 
        
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int res = 0;
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                res = Math.max(res , dfs(i,j));
            }
        }
        System.out.println(res);
    }
}