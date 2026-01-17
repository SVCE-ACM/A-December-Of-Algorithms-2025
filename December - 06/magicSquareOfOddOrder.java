package Dec06;
import java.util.*;
public class magicSquareOfOddOrder {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            if (n % 2 == 0) {
                System.out.println("Magic square is only possible for odd values of n.");
                return;
            }
            int[][] magic = new int[n][n];
            int num = 1;
            int i = 0;
            int j = n / 2;
            while (num <= n * n) {
                magic[i][j] = num++;
                int newI = (i-1 + n) % n;
                int newJ = (j+1) % n;

                if (magic[newI][newJ] != 0) {
                    i = (i+1) % n;
                } else {
                    i = newI;
                    j = newJ;
                }
            }
            int magicConstant = n * (n * n + 1) / 2;
            System.out.println("Magic constant: " + magicConstant);
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    System.out.print(magic[i][j] + " ");
                }
                System.out.println();
            }
        }
    }


