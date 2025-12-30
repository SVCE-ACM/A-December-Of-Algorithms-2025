public class BridgeCrossingChallenge {

    public static boolean canReachLastStone(int[] stones) {
        int maxReach = 0;

        for (int i = 0; i < stones.length; i++) {
            if (i > maxReach) {                                             // If current index is beyond reachable range
                return false;
            }

            maxReach = Math.max(maxReach, i + stones[i]);                   // Update maximum reachable index

            if (maxReach >= stones.length - 1) {                            // If we can already reach or cross last stone
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] stones1 = {2, 3, 1, 1, 4};
        int[] stones2 = {3, 2, 1, 0, 4};

        System.out.println(canReachLastStone(stones1));                         // true
        System.out.println(canReachLastStone(stones2));                         // false
    }
}
