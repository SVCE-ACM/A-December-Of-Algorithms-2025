import java.util.Scanner;
public class MonishMakerPerfectSqare {
    public static void perfectSquare(int n){
        int counter = 0;
        for(int i=1 ; i*i<n ; i++){
            System.out.print(i*i+" ");
            counter += 1; 
        }
        System.err.println();
        System.out.println(counter);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        perfectSquare(n);
    }

}
