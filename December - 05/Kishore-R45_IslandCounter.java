import java.util.Scanner;

public class IslandCounter {
    static int row, col;
    static int[][] map;
    static boolean[][] seen;
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        
        map = new int[row][col];
        seen = new boolean[row][col];
        
        for(int x=0; x<row; x++){
            for(int y=0; y<col; y++){
                map[x][y] = sc.nextInt();
            }
        }
        
        int islands = 0;
        for(int x=0; x<row; x++){
            for(int y=0; y<col; y++){
                if(map[x][y]==1 && !seen[x][y]){
                    explore(x, y);
                    islands++;
                }
            }
        }
        System.out.println(islands);
        sc.close();
    }
    
    static void explore(int x, int y){
        if(x<0 || x>=row || y<0 || y>=col) return;
        if(map[x][y]==0 || seen[x][y]) return;
        
        seen[x][y] = true;
        explore(x+1, y);
        explore(x-1, y);
        explore(x, y+1);
        explore(x, y-1);
    }
}
