import java.util.Scanner;

public class PerfectSquaresCounter {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        String res = "";
        int total = 0;
        
        int x = 1;
        while(x*x <= num) {
            if(total > 0) res = res + " ";
            res = res + (x*x);
            total++;
            x++;
        }
        
        System.out.println(res);
        System.out.println(total);
        sc.close();
    }
}
