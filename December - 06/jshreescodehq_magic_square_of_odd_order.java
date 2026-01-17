import java.util.Scanner;

public class MagicSquareOdd {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        if (n % 2 == 0) {
            System.out.println("Magic square is only possible for odd values of n.");
            sc.close();
            return;
        }

        int[][] magic = new int[n][n];

        int M = n * (n * n + 1) / 2;
        System.out.println("Magic constant: " + M);

        int row = 0;
        int col = n / 2;

        for (int num = 1; num <= n * n; num++) {
            magic[row][col] = num;

            int nextRow = (row - 1 + n) % n;
            int nextCol = (col + 1) % n;

            // If cell already filled
            if (magic[nextRow][nextCol] != 0) {
                row = (row + 1) % n;
            } else {
                row = nextRow;
                col = nextCol;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d ", magic[i][j]);
            }
            System.out.println();
        }

        sc.close();
    }
}
