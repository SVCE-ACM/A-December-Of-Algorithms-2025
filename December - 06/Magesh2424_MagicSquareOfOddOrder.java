import java.util.*;

public class Magesh2424_MagicSquareOfOddOrder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read n
        int n = sc.nextInt();

        // Check for even n
        if (n % 2 == 0) {
            System.out.println("Magic square is only possible for odd values of n.");
            sc.close();
            return;
        }

        int[][] magicSquare = new int[n][n];

        // Siamese method initialization
        int num = 1;
        int i = 0;
        int j = n / 2;

        while (num <= n * n) {
            magicSquare[i][j] = num++;

            int nextI = (i - 1 + n) % n;
            int nextJ = (j + 1) % n;

            // If cell already occupied, move down
            if (magicSquare[nextI][nextJ] != 0) {
                i = (i + 1) % n;
            } else {
                i = nextI;
                j = nextJ;
            }
        }

        // Calculate magic constant
        int magicConstant = n * (n * n + 1) / 2;
        System.out.println("Magic constant: " + magicConstant);

        // Print magic square
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.printf("%3d ", magicSquare[r][c]);
            }
            System.out.println();
        }

        sc.close();
    }
}
