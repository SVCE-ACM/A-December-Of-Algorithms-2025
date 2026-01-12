/* Dhana Anjana
 December 02, 2025
Print the decimal, octal, hexadecimal, and binary values of all integers from 1 to N, formatted with leading zeros */
import java.util.Scanner;
public class java_DhanaAnjana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int width = Integer.toBinaryString(N).length();

        for (int i = 1; i <= N; i++) {
            String decimal = String.format("%" + width + "d", i);
            String octal = String.format("%" + width + "o", i);
            String hexadecimal = String.format("%" + width + "X", i);
            String binary = String.format("%" + width + "s", Integer.toBinaryString(i)).replace(' ', '0');

            System.out.println(decimal + " " + octal + " " + hexadecimal + " " + binary);
        }

        scanner.close();
    }
}