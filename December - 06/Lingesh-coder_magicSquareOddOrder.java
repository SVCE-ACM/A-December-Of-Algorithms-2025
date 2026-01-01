import java.util.*;

public class Lingesh-coder_magicSquareOddOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n % 2 == 0) {
            System.out.println("Magic square is only possible for odd values of n.");
            return;
        }

        int[][] square = generateMagicSquare(n);

        int magicConstant = n * (n * n + 1) / 2;
        System.out.println("Magic constant: " + magicConstant);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(square[i][j] + " ");
            System.out.println();
        }
    }

    public static int[][] generateMagicSquare(int n) {
        int[][] square = new int[n][n];

        int i = 0;
        int j = n / 2;

        for (int num = 1; num <= n * n; num++) {
            square[i][j] = num;

            int nextI = (i - 1 + n) % n;
            int nextJ = (j + 1) % n;

            if (square[nextI][nextJ] != 0) {
                i = (i + 1) % n;
            } else {
                i = nextI;
                j = nextJ;
            }
        }
        return square;
    }
}