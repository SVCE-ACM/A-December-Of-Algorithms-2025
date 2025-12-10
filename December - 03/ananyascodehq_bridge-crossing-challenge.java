class Solution {
    public boolean canJump(int[] stones) {
        int maxReach = 0;
        int last = stones.length - 1;

        for (int i = 0; i < stones.length; i++) {
            if (i > maxReach) {
                return false;   // stuck
            }

            maxReach = Math.max(maxReach, i + stones[i]);

            if (maxReach >= last) {
                return true;    // can reach the last stone
            }
        }

        return true;
    }
}
