import java.util.*;

public class devipriya_l_SweetRewards {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) scores[i] = sc.nextInt();

        int[] sweets = new int[n];
        Arrays.fill(sweets, 1);

        for (int i = 1; i < n; i++)
            if (scores[i] > scores[i-1])
                sweets[i] = sweets[i-1] + 1;

        for (int i = n-2; i >= 0; i--)
            if (scores[i] > scores[i+1])
                sweets[i] = Math.max(sweets[i], sweets[i+1] + 1);

        int sum = 0;
        for (int x : sweets) sum += x;

        System.out.println(sum);
    }
}
