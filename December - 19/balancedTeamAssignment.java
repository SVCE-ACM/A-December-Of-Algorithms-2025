package Dec19;
import java.util.*;
public class balancedTeamAssignment {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int N = sc.nextInt();
            int[] skills = new int[N];

            int totalSum = 0;
            for (int i = 0; i < N; i++) {
                skills[i] = sc.nextInt();
                totalSum += skills[i];
            }

            // DP array: dp[s] = true if subset sum s is possible
            boolean[] dp = new boolean[totalSum + 1];
            dp[0] = true;

            for (int skill : skills) {
                for (int s = totalSum; s >= skill; s--) {
                    dp[s] = dp[s] || dp[s - skill];
                }
            }

            int minDiff = Integer.MAX_VALUE;

            for (int s = 0; s <= totalSum / 2; s++) {
                if (dp[s]) {
                    int diff = Math.abs(totalSum - 2 * s);
                    minDiff = Math.min(minDiff, diff);
                }
            }

            System.out.println(minDiff);
        }
    }




