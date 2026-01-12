import java.util.*;

public class SumOfUniqueElements {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        HashMap<Integer,Integer> cnt = new HashMap<>();
        
        for(int x=0; x<n; x++){
            int val = sc.nextInt();
            cnt.put(val, cnt.getOrDefault(val, 0) + 1);
        }
        
        long ans = 0;
        for(int key : cnt.keySet()){
            if(cnt.get(key) == 1){
                ans += key;
            }
        }
        
        System.out.println(ans);
        sc.close();
    }
}
