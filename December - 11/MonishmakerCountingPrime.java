import java.util.Scanner;
public class MonishmakerCountingPrime {
    public static boolean isPrime(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public static int countingPrime(int n){
        int count = 0;
        for(int i=2;i<n;i++){
            if(isPrime(i))
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.err.print("Enter N:");
        int n = sc.nextInt();
        System.out.print("The count of prime numbers less then "+n+" is:"+countingPrime(n));
    }
    
}
