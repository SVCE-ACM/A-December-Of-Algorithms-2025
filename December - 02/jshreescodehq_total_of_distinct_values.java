import java.util.Scanner;

public class NumberSystemTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int width = Integer.toBinaryString(N).length();

        for (int i = 1; i <= N; i++) {
            String dec = String.valueOf(i);
            String oct = Integer.toOctalString(i);
            String hex = Integer.toHexString(i).toUpperCase();
            String bin = Integer.toBinaryString(i);

            System.out.printf("%" + width + "s %" + width + "s %" + width + "s %" + width + "s%n",
                    dec, oct, hex, bin);
        }

        sc.close();
    }
}
