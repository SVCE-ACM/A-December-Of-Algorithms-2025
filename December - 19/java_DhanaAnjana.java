import java.util.Scanner;

public class java_DhanaAnjana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] skills = new int[n];
        
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            skills[i] = scanner.nextInt();
            totalSum += skills[i];
        }
        
        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        
        for (int skill : skills) {
            for (int j = target; j >= skill; j--) {
                dp[j] = dp[j] || dp[j - skill];
            }
        }
        
        int maxSum = 0;
        for (int i = target; i >= 0; i--) {
            if (dp[i]) {
                maxSum = i;
                break;
            }
        }
        
        int minDifference = Math.abs(totalSum - 2 * maxSum);
        System.out.println(minDifference);
        
        scanner.close();
    }
}
