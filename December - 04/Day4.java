import java.util.*;
public class Day4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int tar = in.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        
        Map<Long, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0L, -1);
        long sum = 0;
        
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            
            if (prefixSum.containsKey(sum - tar)) {
                System.out.println((prefixSum.get(sum - tar) + 1) + " " + i);
                return;
            }
            
            prefixSum.put(sum, i);
        }
        
        System.out.println("-1 -1");
    }
}