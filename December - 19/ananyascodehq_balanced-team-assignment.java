import java.util.*;

class BalancedTeams {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] skills = new int[N];
        int sum = 0;

        for(int i = 0; i < N; i++){
            skills[i] = sc.nextInt();
            sum += skills[i];
        }

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for(int skill : skills){
            for(int s = sum; s >= skill; s--){
                dp[s] = dp[s] || dp[s - skill];
            }
        }

        int best = 0;
        for(int s = sum / 2; s >= 0; s--){
            if(dp[s]){
                best = s;
                break;
            }
        }

        int minDiff = sum - 2 * best;
        System.out.println(minDiff);
    }
}
