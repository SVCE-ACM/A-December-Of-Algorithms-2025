import java.util.*;

public class SakthiDharan01_sweet_rewards_students {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] rating = new int[n];
        for (int i = 0; i < n && sc.hasNextInt(); i++) rating[i] = sc.nextInt();
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 1; i < n; i++) if (rating[i] > rating[i-1]) candies[i] = candies[i-1] + 1;
        for (int i = n - 2; i >= 0; i--) if (rating[i] > rating[i+1]) candies[i] = Math.max(candies[i], candies[i+1] + 1);
        long sum = 0; for (int c : candies) sum += c;
        System.out.println(sum);
        sc.close();
    }
}
