import java.util.*;

public class Magesh2424_MirrorNecklaceCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of beads
        int N = sc.nextInt();

        if (N == 0) {
            System.out.println("The necklace is empty.");
            sc.close();
            return;
        }

        int[] beads = new int[N];

        // Read bead values
        for (int i = 0; i < N; i++) {
            beads[i] = sc.nextInt();
        }

        int left = 0, right = N - 1;
        boolean isPalindrome = true;

        // Two-pointer check
        while (left < right) {
            if (beads[left] != beads[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        // Output result
        if (isPalindrome) {
            System.out.println("The necklace is mirrored.");
        } else {
            System.out.println("The necklace is not mirrored.");
        }

        sc.close();
    }
}
