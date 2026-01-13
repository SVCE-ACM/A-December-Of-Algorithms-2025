import java.util.*;

public class charusm03_countPrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println("The count of prime numbers less than " + n + " is: " + countPrimes(n));
    }

    public static int countPrimes(int n) {
        if (n <= 2)
            return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i)
                    isPrime[j] = false;
            }
        }

        int count = 0;
        for (boolean prime : isPrime) {
            if (prime)
                count++;
        }

        return count;
    }
}
