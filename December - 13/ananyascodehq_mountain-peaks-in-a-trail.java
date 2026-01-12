import java.util.*;

public class MountainPeaks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        List<Integer> peaks = new ArrayList<>();

        for (int i = 1; i < n - 1; i++) {
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
    }
}
