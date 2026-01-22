import java.util.*;
public class Magesh2424_PerfectSquaresCounter{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 0;

        // Print perfect squares
        for (int i = 1; i * i <= N; i++) {
            System.out.print((i * i) + " ");
            count++;
        }

        // New line for count
        System.out.println();
        System.out.println(count);

        sc.close();
    }
}