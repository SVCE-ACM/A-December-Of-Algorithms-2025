import java.util.*;

public class MirrorNecklaceCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N == 0) {
            System.out.println("The necklace is empty.");
            return;
        }

        int[] beads = new int[N];
        for (int i = 0; i < N; i++) beads[i] = sc.nextInt();
        int l = 0, r = N - 1;
        while (l < r) {
            if (beads[l] != beads[r]) {
                System.out.println("The necklace is not mirrored.");
                return;
            }
            l++;
            r--;
        }
        System.out.println("The necklace is mirrored.");
    }
}
