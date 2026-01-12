import java.util.Scanner;

public class java_DhanaAnjana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] scores = new int[n];
        
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        
        int[] candies = new int[n];
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            if (scores[i] > scores[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        for (int i = n - 2; i >= 0; i--) {
            if (scores[i] > scores[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        
        System.out.println(sum);
        scanner.close();
    }
}
