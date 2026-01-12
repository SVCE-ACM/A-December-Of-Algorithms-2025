import java.util.Scanner;
public class MonishmakerBalancedTeam {
    public static int balanceTeam(int[] skills){
        int n = skills.length;
        int totalSum = 0;
        for(int i=0;i<n;i++){
            totalSum += skills[i];
        }
        boolean[] dp = new boolean[totalSum + 1];
        dp[0] = true;
        for(int x : skills){
            for(int s= totalSum;s>=x;s--){
                dp[s] = dp[s] || dp[s-x];
            }
        }
         int minDiff = Integer.MAX_VALUE;
        
         for(int s=0;s<=totalSum/2;s++){
            if(dp[s]){
                minDiff = Math.min(minDiff,totalSum -2*s);
            }
         }
         return minDiff;
    }    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] skills = new int[n];
        for(int i=0;i<n;i++){
            skills[i] = sc.nextInt();
        }
        System.out.println(balanceTeam(skills));
    }
}
