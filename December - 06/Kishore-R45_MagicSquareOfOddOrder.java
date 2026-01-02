import java.util.Scanner;

public class MagicSquareOfOddOrder {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int size = sc.nextInt();
        
        if(size%2 == 0){
            System.out.println("Magic square is only possible for odd values of n.");
            return;
        }
        
        int[][] sq = new int[size][size];
        
        int r = 0;
        int c = size/2;
        
        for(int val=1; val<=size*size; val++){
            sq[r][c] = val;
            
            int nextR = (r-1+size) % size;
            int nextC = (c+1) % size;
            
            if(sq[nextR][nextC] == 0){
                r = nextR;
                c = nextC;
            } else {
                r = (r+1) % size;
            }
        }
        
        int magic = size*(size*size+1)/2;
        System.out.println("Magic constant: " + magic);
        
        for(int x=0; x<size; x++){
            for(int y=0; y<size; y++){
                System.out.printf("%3d ", sq[x][y]);
            }
            System.out.println();
        }
        sc.close();
    }
}
