import java.util.*;

public class Magesh2424_BalancedTeamAssignment {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of employees
        int N = sc.nextInt();

        int[] skills = new int[N];
        int totalSum = 0;

        // Read skill values
        for (int i = 0; i < N; i++) {
            skills[i] = sc.nextInt();
            totalSum += skills[i];
        }

        int target = totalSum / 2;

        // DP array: dp[s] = true if subset sum s is possible
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        // Fill DP table
        for (int skill : skills) {
            for (int s = target; s >= skill; s--) {
                dp[s] = dp[s] || dp[s - skill];
            }
        }

        // Find closest achievable sum to totalSum/2
        int bestSum = 0;
        for (int s = target; s >= 0; s--) {
            if (dp[s]) {
                bestSum = s;
                break;
            }
        }

        // Minimum difference
        int minDifference = totalSum - 2 * bestSum;

        // Output result
        System.out.println(minDifference);

        sc.close();
    }
}
