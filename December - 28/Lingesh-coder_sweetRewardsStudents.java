import java.util.*;

public class Lingesh-coder_sweetRewardsStudents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] score = new int[n];
        for (int i = 0; i < n; i++)
            score[i] = sc.nextInt();

        int[] candy = new int[n];
        Arrays.fill(candy, 1);
        for (int i = 1; i < n; i++)
            if (score[i] > score[i - 1])
                candy[i] = candy[i - 1] + 1;
        for (int i = n - 2; i >= 0; i--)
            if (score[i] > score[i + 1])
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);

        int sum = 0;
        for (int c : candy)
            sum += c;
        System.out.println(sum);
    }
}
