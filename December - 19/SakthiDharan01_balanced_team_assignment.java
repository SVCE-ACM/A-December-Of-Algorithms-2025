import java.util.*;

public class SakthiDharan01_balanced_team_assignment {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] arr = new int[n];
        int total = 0;
        for (int i=0;i<n && sc.hasNextInt();i++) {arr[i]=sc.nextInt(); total += arr[i];}
        int target = total / 2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for (int num : arr){
            for (int s = target; s >= num; s--){
                dp[s] = dp[s] || dp[s-num];
            }
        }
        int best=0;
        for (int i=target;i>=0;i--){
            if (dp[i]) {best=i; break;}
        }
        int diff = total - 2*best;
        System.out.println(diff);
        sc.close();
    }
}
