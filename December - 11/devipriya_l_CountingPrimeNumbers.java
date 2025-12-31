import java.util.*;

public class devipriya_l_CountingPrimeNumbers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (N <= 2) {
            System.out.println("The count of prime numbers less than " + N + " is: 0");
            sc.close();
            return;
        }

        boolean[] isPrime = new boolean[N];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < N; i++) {
            if (isPrime[i]) count++;
        }
        System.out.println("The count of prime numbers less than " + N + " is: " + count);
        sc.close();
    }
}
