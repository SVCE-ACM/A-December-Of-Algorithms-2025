import java.util.*;

public class Magesh2424_MountainPeaksInATrail {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of checkpoints
        int N = sc.nextInt();

        int[] heights = new int[N];

        // Read elevations
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }

        List<Integer> peaks = new ArrayList<>();

        // Check for mountain peaks
        for (int i = 1; i < N - 1; i++) {
            if (heights[i] > heights[i - 1] && heights[i] > heights[i + 1]) {
                peaks.add(i);
            }
        }

        // Output result
        if (peaks.isEmpty()) {
            System.out.println("-1");
        } else {
            for (int index : peaks) {
                System.out.print(index + " ");
            }
        }

        sc.close();
    }
}
