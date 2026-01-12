import java.util.Scanner;
public class MonishmakerMirrorNecklaceCheck {
    public static void mirrorNecklaceCheck(int[] beads){
        int n = beads.length;
        boolean isPalindrome = true;
        for(int i=0;i<n/2;i++){
            if(beads[i] != beads[n-1-i]){
                isPalindrome = false;
                break;
            }
        }
        if(isPalindrome)
            System.out.println("The necklace is mirrored.");
        else
            System.out.println("The necklace is not mirrored.");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N:");
        int n = sc.nextInt();
        if(n>0){
            int[] beads = new int[n];
            System.out.print("Beads:");
        for(int i=0;i<n;i++){
            beads[i] = sc.nextInt();
            }
            mirrorNecklaceCheck(beads);
        }else{
System.out.println("The necklace is empty.");
        }
    }
}
