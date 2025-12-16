/* Dhana Anjana
    December 01, 2025
   Print all perfect squares less than or equal to N and count them */
import java.util.Scanner;
public class java_DhanaAnjana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        StringBuilder perfectSquares = new StringBuilder();
        int count = 0;

        for (int i = 1; i * i <= N; i++) {
            perfectSquares.append(i * i).append(" ");
            count++;
        }

        System.out.println(perfectSquares.toString().trim());
        System.out.println(count);
        
        scanner.close();
    }
}