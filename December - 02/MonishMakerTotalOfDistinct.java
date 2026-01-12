import java.util.Scanner;
public class MonishMakerTotalOfDistinct{
    public static String octal(int n){
        if(n==0) return "0";
        String rem = "";
        while(n!=0){
            int r = n%8;
            String octDigit = r + "";
            n = n/8;
            rem = octDigit+rem; 
        }
        return rem;
    }
    public static String hexadecimal(int n){
        if(n==0) return "0";
        String rem = "";
        while(n!=0){
            int r = n%16;
            String hexDigit;
            if(r < 10){
                hexDigit = r + "";
            }else{
                hexDigit = (char)('A' + (r-10))+"";
            }
            n = n /16;
            rem = hexDigit+rem;
        }
        return rem;
    }
    public static String binary(int n){
        if(n==0) return "0";
        String rem = "";
        while(n!=0){
            int r = n%2;
            String binaryDigit;
            binaryDigit = r + "";
            n  = n/2;
            rem = binaryDigit+rem;
        }
        return rem;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            System.out.print(i+" ");
            System.out.print(octal(i)+" ");
            System.out.print(hexadecimal(i)+" ");
            System.out.print(binary(i)+" ");
            System.out.println();
        }
    }
}
 