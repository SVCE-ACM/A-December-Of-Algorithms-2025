import java.util.Scanner;

public class java_DhanaAnjana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        boolean[] isPrime = new boolean[n];
        if (n > 0) {
            for (int i = 2; i < n; i++) {
                isPrime[i] = true;
            }
        }
        
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        
        System.out.println("The count of prime numbers less than " + n + " is: " + count);
        scanner.close();
    }
}
