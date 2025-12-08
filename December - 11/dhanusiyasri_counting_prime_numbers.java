import java.util.Scanner;

public class dhanusiyasri_counting_prime_numbers {
    public static int countPrimes(int n){
        int count=0;
        for(int i=2;i<n;i++){
            boolean isPrime=true;
            for(int j=2;j<=i/2;j++){
                if(i%j==0){
                    isPrime=false;
                    break;
                }
            }
            if(isPrime){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int result=countPrimes(n);
        System.out.println("The count of prime numbers less than " + n + " is: " + result);
        sc.close();
    }
    
}
