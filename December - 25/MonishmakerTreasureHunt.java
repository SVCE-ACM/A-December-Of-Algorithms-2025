import java.util.*;
public class MonishmakerTreasureHunt {
    static class State{
        int x,y,keys,steps;
        State(int x,int y,int keys,int steps){
            this.x = x; this.y = y; this.keys = keys;this.steps = steps;
        }
    }
    public static int minStepsToTreasure(char[][] maze,int M,int N){
        boolean[][][] visited= new boolean[M][N][1 << 10];
        
        int startX = 0, startY = 0;
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(maze[i][j]=='S'){
                    startX = i; startY = j;
                }
            }
        }
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(startX,startY,0,0));
        visited[startX][startY][0] = true;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while(!queue.isEmpty()){
            State curr = queue.poll();
            int x = curr.x, y = curr.y,keys=curr.keys,steps = curr.steps;
            
            if(maze[x][y] == 'T') return steps;

            for(int i=0;i<4;i++){
                int nx = x+ dx[i],ny= y+ dy[i],nkeys = keys;

                if(nx < 0 || nx >=M || ny < 0 || ny >= N) continue;
                char cell = maze[nx][ny];

                if(cell == '#') continue;

                if(cell >= 'A' && cell <= 'J'){
                    int door = cell-'A';
                    if((keys & (1 << door))==0) continue;
                }

                if(cell >= 'a' && cell <= 'j'){
                    nkeys |= (1 <<(cell -'a'));
                }
                if(!visited[nx][ny][nkeys]){
                    visited[nx][ny][nkeys] = true;
                    queue.offer(new State(nx,ny,nkeys,steps+1));
                }

            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int M = sc.nextInt(),N = sc.nextInt();
        sc.nextLine();
        char[][] maze = new char[M][N];
        for(int i=0;i<M;i++){
            maze[i] = sc.nextLine().toCharArray();
        }
        System.out.println(minStepsToTreasure(maze,M,N));
        sc.close();
    }
}
