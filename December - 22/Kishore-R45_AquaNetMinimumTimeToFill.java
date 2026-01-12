import java.util.*;

public class AquaNetMinimumTimeToFill {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int x=0; x<v; x++) adj.add(new ArrayList<>());
        
        for(int x=0; x<e; x++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        int[] water = new int[v];
        for(int x=0; x<v; x++) water[x] = sc.nextInt();
        
        int[] fillTime = new int[v];
        for(int x=0; x<v; x++) fillTime[x] = -1;
        
        LinkedList<Integer> q = new LinkedList<>();
        
        for(int x=0; x<v; x++){
            if(water[x] == 1){
                q.add(x);
                fillTime[x] = 0;
            }
        }
        
        int maxT = 0;
        
        while(!q.isEmpty()){
            int curr = q.removeFirst();
            
            for(int nb : adj.get(curr)){
                if(fillTime[nb] == -1){
                    fillTime[nb] = fillTime[curr] + 1;
                    if(fillTime[nb] > maxT) maxT = fillTime[nb];
                    q.add(nb);
                }
            }
        }
        
        for(int x=0; x<v; x++){
            if(fillTime[x] == -1){
                System.out.println(-1);
                return;
            }
        }
        
        System.out.println(maxT);
        sc.close();
    }
}
