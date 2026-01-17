import java.util.*;

public class SakthiDharan01_mirror_necklace_check {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] beads = new int[n];
        for (int i=0;i<n && sc.hasNextInt();i++) beads[i]=sc.nextInt();
        if (n==0){
            System.out.println("The necklace is empty.");
            return;
        }
        boolean ok=true;
        for (int i=0;i<n/2;i++){
            if (beads[i]!=beads[n-1-i]){ok=false;break;}
        }
        if (ok) System.out.println("The necklace is mirrored.");
        else System.out.println("The necklace is not mirrored.");
        sc.close();
    }
}
