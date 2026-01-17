import java.util.Scanner;

public class BalancedTeamAssignment {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] skills = new int[N];

        int totalSum = 0;
        for (int i = 0; i < N; i++) {
            skills[i] = sc.nextInt();
            totalSum += skills[i];
        }

        int half = totalSum / 2;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        for (int skill : skills) {
            for (int j = half; j >= skill; j--) {
                dp[j] = dp[j] || dp[j - skill];
            }
        }
        int best = 0;
        for (int i = half; i >= 0; i--) {
            if (dp[i]) {
                best = i;
                break;
            }
        }

        int minDifference = Math.abs(totalSum - 2 * best);
        System.out.println(minDifference);

        sc.close();
    }
}
