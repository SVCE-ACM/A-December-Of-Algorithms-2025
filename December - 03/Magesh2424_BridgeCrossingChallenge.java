import java.util.*;

public class Magesh2424_BridgeCrossingChallenge {

    public static boolean canReachLastStone(int[] stones) {
        int maxReach = 0;

        for (int i = 0; i < stones.length; i++) {
            // If current index is not reachable
            if (i > maxReach) {
                return false;
            }

            // Update the farthest reachable stone
            maxReach = Math.max(maxReach, i + stones[i]);

            // If we can reach the last stone
            if (maxReach >= stones.length - 1) {
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of stones
        int n = sc.nextInt();

        int[] stones = new int[n];

        // Input stone values
        for (int i = 0; i < n; i++) {
            stones[i] = sc.nextInt();
        }

        // Output result
        System.out.println(canReachLastStone(stones));

        sc.close();
    }
}
