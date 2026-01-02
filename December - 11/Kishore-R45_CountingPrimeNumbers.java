import java.util.*;

public class CountingPrimeNumbers {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int num = sc.nextInt();
        
        if(num <= 2){
            System.out.println("The count of prime numbers less than " + num + " is: 0");
            return;
        }
        
        boolean[] notPrime = new boolean[num];
        notPrime[0] = true;
        notPrime[1] = true;
        
        for(int x=2; x*x<num; x++){
            if(!notPrime[x]){
                for(int y=x*x; y<num; y+=x){
                    notPrime[y] = true;
                }
            }
        }
        
        int total = 0;
        for(int x=2; x<num; x++){
            if(!notPrime[x]) total++;
        }
        
        System.out.println("The count of prime numbers less than " + num + " is: " + total);
        sc.close();
    }
}
