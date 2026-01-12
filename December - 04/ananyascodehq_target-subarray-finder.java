// December 04 - Target Subarray Finder
/*
Problem Statement
You are given a collection of numbers and a target value. Your task is to find a
contiguous segment of numbers in the collection whose sum equals the target.

- If such a segment exists, report the starting and ending indices (0-based).
- If no such segment exists, report -1 -1.

Input Format:
Two integers, N (number of elements) and K (target sum).
N space-separated integers — the elements of the array.

Output Format:
Two integers — the starting and ending indices of a subarray whose sum is K,
or -1 -1 if no such subarray exists.

Sample Input 1:
7 15
1 2 3 7 5 1 2

Sample Output 1:
2 4

Sample Input 2:
5 100
10 20 30 40 50

Sample Output 2:
-1 -1

Explanation:
The subarray [3, 7, 5] (indices 2 to 4) sums to 15.

Constraints:
1 ≤ N ≤ 10^5
-10^9 ≤ array elements ≤ 10^9
-10^9 ≤ K ≤ 10^9
*/

/*
Approach:
We use a prefix-sum + hashmap technique:
- Maintain a running sum.
- For each index i, check whether (runningSum - K) was seen before.
  If yes, then subarray(startIndex+1 ... i) is a valid solution.
- If runningSum == K, then subarray(0 ... i) is valid.
This handles negative numbers, unlike sliding-window.
Time: O(N)
Space: O(N)
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long K = sc.nextLong();

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) arr[i] = sc.nextLong();

        // Maps prefixSum → first index where it occurred
        Map<Long, Integer> map = new HashMap<>();

        long prefix = 0;
        for (int i = 0; i < N; i++) {
            prefix += arr[i];

            // Case 1: prefix itself equals K (subarray from 0 to i)
            if (prefix == K) {
                System.out.println(0 + " " + i);
                return;
            }

            // Case 2: prefix - K seen before → valid subarray
            long need = prefix - K;
            if (map.containsKey(need)) {
                System.out.println(map.get(need) + 1 + " " + i);
                return;
            }

            // Store prefix sum if not already present
            map.putIfAbsent(prefix, i);
        }

        // No subarray found
        System.out.println("-1 -1");
    }
}
