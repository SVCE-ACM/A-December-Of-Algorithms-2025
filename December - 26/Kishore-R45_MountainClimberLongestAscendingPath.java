import java.util.Scanner;

public class MountainClimberLongestAscendingPath {
    static int rows, cols;
    static int[][] height;
    static int[][] cache;
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        rows = sc.nextInt();
        cols = sc.nextInt();
        
        height = new int[rows][cols];
        cache = new int[rows][cols];
        
        for(int x=0; x<rows; x++){
            for(int y=0; y<cols; y++){
                height[x][y] = sc.nextInt();
            }
        }
        
        int longest = 0;
        for(int x=0; x<rows; x++){
            for(int y=0; y<cols; y++){
                int len = findPath(x, y);
                if(len > longest) longest = len;
            }
        }
        
        System.out.println(longest);
        sc.close();
    }
    
    static int findPath(int r, int c){
        if(cache[r][c] != 0) return cache[r][c];
        
        int best = 1;
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        
        for(int d=0; d<4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if(nr>=0 && nr<rows && nc>=0 && nc<cols){
                if(height[nr][nc] > height[r][c]){
                    int pathLen = 1 + findPath(nr, nc);
                    if(pathLen > best) best = pathLen;
                }
            }
        }
        
        cache[r][c] = best;
        return best;
    }
}
