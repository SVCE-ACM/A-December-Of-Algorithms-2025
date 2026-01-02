import java.util.*;

public class TargetSubarrayFinder {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[len];
        
        for(int x=0; x<len; x++) a[x] = sc.nextInt();
        
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(0L, -1);
        long runningSum = 0;
        
        for(int x=0; x<len; x++){
            runningSum += a[x];
            long need = runningSum - k;
            
            if(map.containsKey(need)){
                int start = map.get(need) + 1;
                System.out.println(start + " " + x);
                return;
            }
            map.put(runningSum, x);
        }
        System.out.println("-1 -1");
        sc.close();
    }
}
