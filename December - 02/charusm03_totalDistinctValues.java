import java.util.Scanner;

public class charusm03_totalDistinctValues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = Integer.toBinaryString(n).length();
        for (int i = 1; i <= n; i++) {
            String dec = String.valueOf(i);
            String oct = Integer.toOctalString(i);
            String hexa = Integer.toHexString(i).toUpperCase();
            String bina = Integer.toBinaryString(i);
            System.out.printf("%" + (w + 4) + "s %" + (w + 4) + "s %" + (w + 4) + "s %" + (w + 4) + "s\n",
                    dec, oct, hexa, bina);
        }
    }
}
