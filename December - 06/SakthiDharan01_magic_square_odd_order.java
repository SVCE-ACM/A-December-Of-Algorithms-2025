import java.util.*;

public class SakthiDharan01_magic_square_odd_order {
    private static int[][] generate(int n) {
        int[][] m = new int[n][n];
        int i = 0, j = n / 2;
        for (int num = 1; num <= n * n; num++) {
            m[i][j] = num;
            int ni = (i - 1 + n) % n;
            int nj = (j + 1) % n;
            if (m[ni][nj] != 0) {
                i = (i + 1) % n;
            } else {
                i = ni;
                j = nj;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        if (n % 2 == 0) {
            System.out.println("Magic square is only possible for odd values of n.");
            return;
        }
        int M = n * (n * n + 1) / 2;
        int[][] square = generate(n);
        System.out.println("Magic constant: " + M);
        for (int[] row : square) {
            for (int i = 0; i < row.length; i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(row[i]);
            }
            System.out.println();
        }
        sc.close();
    }
}
