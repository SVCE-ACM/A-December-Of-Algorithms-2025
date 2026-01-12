import java.util.Scanner;

public class java_DhanaAnjana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        if (n == 0) {
            System.out.println("The necklace is empty.");
            scanner.close();
            return;
        }
        
        int[] beads = new int[n];
        for (int i = 0; i < n; i++) {
            beads[i] = scanner.nextInt();
        }
        
        boolean isMirrored = true;
        for (int i = 0; i < n / 2; i++) {
            if (beads[i] != beads[n - 1 - i]) {
                isMirrored = false;
                break;
            }
        }
        
        if (isMirrored) {
            System.out.println("The necklace is mirrored.");
        } else {
            System.out.println("The necklace is not mirrored.");
        }
        
        scanner.close();
    }
}
