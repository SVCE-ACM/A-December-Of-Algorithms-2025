import java.util.*;
public class Day3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] stones = new int[n];
        
        for (int i = 0; i < n; i++) {
            stones[i] = in.nextInt();
        }
        
        int maxReach = 0;
        
        for (int i = 0; i < n; i++) {
            if (i > maxReach) {
                System.out.println(false);
                return;
            }
            maxReach = Math.max(maxReach, i + stones[i]);
            if (maxReach >= n - 1) {
                System.out.println(true);
                return;
            }
        }
        
        System.out.println(maxReach >= n - 1);
    }
}