import java.util.*;

public class Lingesh-coder_mirrorNecklace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        if (N == 0) {
            System.out.println("The necklace is empty.");
            return;
        }

        int[] beads = new int[N];
        for (int i = 0; i < N; i++)
            beads[i] = sc.nextInt();

        boolean mirrored = true;
        for (int i = 0; i < N / 2; i++) {
            if (beads[i] != beads[N - 1 - i]) {
                mirrored = false;
                break;
            }
        }

        if (mirrored)
            System.out.println("The necklace is mirrored.");
        else
            System.out.println("The necklace is not mirrored.");
    }
}
