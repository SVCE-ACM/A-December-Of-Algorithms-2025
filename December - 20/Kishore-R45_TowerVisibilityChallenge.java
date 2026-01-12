import java.util.*;

public class TowerVisibilityChallenge {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tower = new int[n];
        
        for(int x=0; x<n; x++) tower[x] = sc.nextInt();
        
        int[] nextTaller = new int[n];
        for(int x=0; x<n; x++) nextTaller[x] = -1;
        
        Stack<Integer> stk = new Stack<>();
        
        for(int x=n-1; x>=0; x--){
            while(!stk.isEmpty() && stk.peek() <= tower[x]){
                stk.pop();
            }
            
            if(!stk.isEmpty()){
                nextTaller[x] = stk.peek();
            }
            
            stk.push(tower[x]);
        }
        
        String out = "";
        for(int x=0; x<n; x++){
            out += nextTaller[x];
            if(x < n-1) out += " ";
        }
        System.out.println(out);
        sc.close();
    }
}
