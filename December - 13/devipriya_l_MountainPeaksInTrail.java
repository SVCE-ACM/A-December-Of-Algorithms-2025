import java.util.*;

public class devipriya_l_MountainPeaksInTrail {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] heights = new int[N];

        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }

        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i <= N - 2; i++) {
            if (heights[i] > heights[i - 1] && heights[i] > heights[i + 1]) {
                peaks.add(i);
            }
        }

        if (peaks.isEmpty()) {
            System.out.println("-1");
        } else {
            for (int idx : peaks) {
                System.out.print(idx + " ");
            }
        }
        sc.close();
    }
}
