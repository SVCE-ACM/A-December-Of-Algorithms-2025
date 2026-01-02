import java.util.Scanner;

public class java_DhanaAnjana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        if (n % 2 == 0) {
            System.out.println("Magic square is only possible for odd values of n.");
        } else {
            int[][] magicSquare = generateMagicSquare(n);
            int magicConstant = n * (n * n + 1) / 2;
            
            System.out.println("Magic constant: " + magicConstant);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%2d ", magicSquare[i][j]);
                }
                System.out.println();
            }
        }
        
        scanner.close();
    }
    
    static int[][] generateMagicSquare(int n) {
        int[][] magicSquare = new int[n][n];
        
        int row = 0;
        int col = n / 2;
        
        for (int num = 1; num <= n * n; num++) {
            magicSquare[row][col] = num;
            
            int nextRow = (row - 1 + n) % n;
            int nextCol = (col + 1) % n;
            
            if (magicSquare[nextRow][nextCol] != 0) {
                nextRow = (row + 1) % n;
                nextCol = col;
            }
            
            row = nextRow;
            col = nextCol;
        }
        
        return magicSquare;
    }
}
