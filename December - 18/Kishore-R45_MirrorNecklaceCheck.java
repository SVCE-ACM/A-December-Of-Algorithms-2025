import java.util.Scanner;

public class MirrorNecklaceCheck {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("N = ");
        int n = sc.nextInt();
        
        if(n == 0){
            System.out.println("The necklace is empty.");
            return;
        }
        
        int[] beads = new int[n];
        System.out.print("Beads = ");
        for(int x=0; x<n; x++) beads[x] = sc.nextInt();
        
        boolean mirror = true;
        int i = 0, j = n-1;
        
        while(i < j){
            if(beads[i] != beads[j]){
                mirror = false;
                break;
            }
            i++; j--;
        }
        
        if(mirror){
            System.out.println("The necklace is mirrored.");
        }
        else{
            System.out.println("The necklace is not mirrored.");
        }
        sc.close();
    }
}
