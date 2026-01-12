/* 
Problem: Sum of Unique Elements
Approach:
- Build a frequency map for all array elements.
- Sum only those values that appear exactly once.
- Return 0 if no such elements exist.
Time Complexity: O(N)
Space Complexity: O(N)
*/

import java.util.*;

class Solution {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Count frequencies
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Sum elements with frequency 1
        int sum = 0;
        for (int num : nums) {
            if (freq.get(num) == 1) {
                sum += num;
            }
        }

        return sum;
    }
}
