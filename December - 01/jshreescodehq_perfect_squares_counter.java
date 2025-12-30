import java.util.Scanner;

public class PerfectSquaresCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;
        for (int i = 1; i * i <= N; i++) {
            System.out.print((i * i) + " ");
            count++;
        }

        System.out.println(); 
        System.out.println(count);
        sc.close();
    }
}
