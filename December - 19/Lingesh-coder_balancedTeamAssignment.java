import java.util.*;

public class Lingesh-coder_balancedTeamAssignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] skills = new int[N];
        int total = 0;
        for (int i = 0; i < N; i++) {
            skills[i] = sc.nextInt();
            total += skills[i];
        }

        boolean[] dp = new boolean[total / 2 + 1];
        dp[0] = true;

        for (int skill : skills) {
            for (int j = total / 2; j >= skill; j--) {
                dp[j] |= dp[j - skill];
            }
        }

        int best = 0;
        for (int j = total / 2; j >= 0; j--) {
            if (dp[j]) {
                best = j;
                break;
            }
        }

        System.out.println(total - 2 * best);
    }
}
