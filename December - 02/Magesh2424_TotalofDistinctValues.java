import java.util.*;

public class Magesh2424_TotalofDistinctValues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // Width based on binary length of N
        int width = Integer.toBinaryString(N).length();

        for (int i = 1; i <= N; i++) {
            String decimal = String.valueOf(i);
            String octal = Integer.toOctalString(i);
            String hex = Integer.toHexString(i).toUpperCase();
            String binary = Integer.toBinaryString(i);

            System.out.printf(
                "%" + width + "s %" + width + "s %" + width + "s %" + width + "s%n",
                decimal, octal, hex, binary
            );
        }

        sc.close();
    }
}

