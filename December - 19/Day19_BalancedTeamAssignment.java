import java.util.*;

public class Day19_BalancedTeamAssignment {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt(); int[] a=new int[N]; int sum=0; for(int i=0;i<N;i++){a[i]=sc.nextInt(); sum+=a[i];}
        int target=sum/2; boolean[] dp=new boolean[target+1]; dp[0]=true;
        for(int v:a){ for(int s=target;s>=v;s--) if(dp[s-v]) dp[s]=true; }
        int best=0; for(int s=0;s<=target;s++) if(dp[s]) best=s;
        System.out.println(Math.abs((sum-best)-best)); sc.close();
    }
}
