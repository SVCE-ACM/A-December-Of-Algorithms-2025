import java.util.*;

public class Magesh2424_CountingPrimeNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read N
        int N = sc.nextInt();

        if (N <= 2) {
            System.out.println("The count of prime numbers less than " + N + " is: 0");
            sc.close();
            return;
        }

        boolean[] isPrime = new boolean[N];
        Arrays.fill(isPrime, true);

        // 0 and 1 are not prime
        isPrime[0] = false;
        isPrime[1] = false;

        // Sieve of Eratosthenes
        for (int i = 2; i * i < N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Count primes
        int count = 0;
        for (int i = 2; i < N; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        // Output result
        System.out.println("The count of prime numbers less than " + N + " is: " + count);

        sc.close();
    }
}
