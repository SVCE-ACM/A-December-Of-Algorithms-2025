import java.util.Scanner;

public class TotalOfDistinctValues {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        
        for(int x=1; x<=num; x++){
            String dec = String.valueOf(x);
            String oct = Integer.toOctalString(x);
            String hex = Integer.toHexString(x).toUpperCase();
            String bin = Integer.toBinaryString(x);
            
            System.out.printf("%5s%6s%6s%7s%n", dec, oct, hex, bin);
        }
        sc.close();
    }
}
