import java.util.Scanner;
public class MonishmakerMagicSquare{
    public static void magicSquare(int n){
        int[][] magicSq = new int[n][n];

        int row = 0;
        int col = n/2;

        for(int i=1;i<=n*n;i++){
            magicSq[row][col] = i;

            int nrow = (row-1+n)%n ;
            int ncol = (col+1)%n;

            if(magicSq[nrow][ncol] !=0){
                row = (row+1)%n;
            }else{
                row = nrow;
                col = ncol;
            }
        }
        int magicNumber = (n*(n*n + 1)) / 2;
        System.out.println("Magic Number:"+magicNumber);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(magicSq[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n%2==0){
            System.out.println("Magic square is only possible for odd values of n.");
        }else{
            magicSquare(n);
        }
    }
}