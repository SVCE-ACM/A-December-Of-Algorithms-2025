import java.util.Scanner;

public class MirrorNecklaceCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        if (N == 0) {
            System.out.println("The necklace is empty.");
            sc.close();
            return;
        }

        int[] beads = new int[N];
        for (int i = 0; i < N; i++) {
            beads[i] = sc.nextInt();
        }

        int left = 0;
        int right = N - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (beads[left] != beads[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        if (isPalindrome) {
            System.out.println("The necklace is mirrored.");
        } else {
            System.out.println("The necklace is not mirrored.");
        }

        sc.close();
    }
}
