import java.util.*;

public class SakthiDharan01_treasure_hunt_locked_maze {
    private static class State{
        int x,y,keys,dist;
        State(int x,int y,int k,int d){this.x=x;this.y=y;this.keys=k;this.dist=d;}
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int m = sc.nextInt();
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine();
        char[][] grid = new char[m][n];
        int sx=-1, sy=-1, tx=-1, ty=-1;
        for (int i=0;i<m;i++){
            String line = sc.nextLine();
            for (int j=0;j<n && j<line.length();j++){
                char c = line.charAt(j);
                grid[i][j]=c;
                if (c=='S'){sx=i;sy=j;}
                if (c=='T'){tx=i;ty=j;}
            }
        }
        if (sx==-1 || tx==-1){
            System.out.println(-1);
            return;
        }
        boolean[][][] vis = new boolean[m][n][1<<10];
        ArrayDeque<State> q = new ArrayDeque<>();
        q.add(new State(sx,sy,0,0));
        vis[sx][sy][0]=true;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()){
            State cur = q.poll();
            if (cur.x==tx && cur.y==ty){
                System.out.println(cur.dist);
                return;
            }
            for (int[] d: dirs){
                int nx = cur.x + d[0], ny = cur.y + d[1];
                if (nx<0||nx>=m||ny<0||ny>=n) continue;
                char cell = grid[nx][ny];
                if (cell=='#') continue;
                int keys = cur.keys;
                if (cell>='a' && cell<='j') keys |= 1 << (cell-'a');
                if (cell>='A' && cell<='J'){
                    if ((keys & (1 << (cell-'A'))) == 0) continue;
                }
                if (!vis[nx][ny][keys]){
                    vis[nx][ny][keys]=true;
                    q.add(new State(nx,ny,keys,cur.dist+1));
                }
            }
        }
        System.out.println(-1);
        sc.close();
    }
}
