import java.util.*;

public class devipriya_l_BalancedTeamAssignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] skills = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            skills[i] = sc.nextInt();
            sum += skills[i];
        }
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;

        for (int skill : skills) {
            for (int j = sum / 2; j >= skill; j--) {
                dp[j] |= dp[j - skill];
            }
        }

        int minDiff = Integer.MAX_VALUE;
        for (int j = 0; j <= sum / 2; j++) {
            if (dp[j]) {
                minDiff = Math.min(minDiff, sum - 2 * j);
            }
        }
        System.out.println(minDiff);
    }
}
