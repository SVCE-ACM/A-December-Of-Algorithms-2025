public class devipriya_l_BridgeCrossingChallenge {

    public static boolean canReachLastStone(int[] stones) {
        int maxReach = 0;

        for (int i = 0; i < stones.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + stones[i]);
            if (maxReach >= stones.length - 1) {
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] stones1 = {2, 3, 1, 1, 4};
        int[] stones2 = {3, 2, 1, 0, 4};

        System.out.println(canReachLastStone(stones1)); 
        System.out.println(canReachLastStone(stones2)); 
    }
}
