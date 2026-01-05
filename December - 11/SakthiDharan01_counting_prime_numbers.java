import java.util.*;

public class SakthiDharan01_counting_prime_numbers {
    private static int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int p = 2; p * p < n; p++) {
            if (isPrime[p]) {
                for (int mult = p * p; mult < n; mult += p) {
                    isPrime[mult] = false;
                }
            }
        }
        int count = 0;
        for (boolean b : isPrime) if (b) count++;
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        System.out.println("The count of prime numbers less than " + n + " is: " + countPrimes(n));
        sc.close();
    }
}
