import java.util.*;

public class Day06_MagicSquareOfOddOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 == 0) { System.out.println("Magic square is only possible for odd values of n."); sc.close(); return; }
        int[][] m = new int[n][n];
        int num = 1; int i = 0, j = n/2;
        while (num <= n*n) {
            m[i][j] = num++;
            int ni = (i-1+n)%n, nj = (j+1)%n;
            if (m[ni][nj] != 0) { i = (i+1)%n; } else { i = ni; j = nj; }
        }
        long M = (long)n*(n*n+1)/2;
        System.out.println("Magic constant: " + M);
        for (int r=0;r<n;r++){for(int c=0;c<n;c++){System.out.print(m[r][c]); if(c<n-1) System.out.print(" ");} System.out.println();}
        sc.close();
    }
}
