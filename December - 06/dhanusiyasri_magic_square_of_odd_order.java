import java.util.Scanner;

public class dhanusiyasri_magic_square_of_odd_order {
    public static int[][] generateMagicSquare(int n) {
       int[][] magic = new int[n][n];
int number = 1;
int i = n - 1, j = n / 2; // bottom middle

while (number <= n * n) {
    magic[i][j] = number++;

    int newI = (i + 1) % n; // move down (wrap around)
    int newJ = (j + 1) % n; // move right (wrap around)

    if (magic[newI][newJ] != 0) {
        i = (i - 1 + n) % n; // move up if occupied
    } else {
        i = newI;
        j = newJ;
    }
    }
       return magic;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        sc.close();
        if (n < 1 || n % 2 == 0) {
            System.out.println("Magic square is only possible for odd values of n.");
            return;
        }
        
        int[][] magic = generateMagicSquare(n);
        int magicConstant = n * (n * n + 1) / 2;
        System.out.println("\nMagic Constant: " + magicConstant);
        for (int[] row : magic) {
            for (int val : row) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
    }
    
}
