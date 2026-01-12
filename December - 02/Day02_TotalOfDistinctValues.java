import java.util.Scanner;

public class Day02_TotalOfDistinctValues {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int maxWidth = Integer.toBinaryString(N).length();

        for (int i = 1; i <= N; i++) {
            String dec = String.format("%" + maxWidth + "d", i);
            String oct = String.format("%" + maxWidth + "s", Integer.toOctalString(i));
            String hex = String.format("%" + maxWidth + "s", Integer.toHexString(i).toUpperCase());
            String bin = String.format("%" + maxWidth + "s", Integer.toBinaryString(i));

            System.out.println(dec + " " + oct + " " + hex + " " + bin);
        }

        sc.close();
    }
}
