package Dec11;
import java.util.*;
public class CountingPrimeNumbers {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isprime(i)) {
                count++;
            }

        }
        System.out.println(count);

    }
    static boolean isprime(int n) {
        if (n == 0 || n == 1) {
            return false;
        } else if (n == 2) {
            return true;
        }else if(n%2==0){
            return false;
        }
        else {
            for (int i = 3; i < n / 2; i+=2) {
                if (n % i == 0) {
                    return false;
                }
            }
        }
        return true;

    }
}

