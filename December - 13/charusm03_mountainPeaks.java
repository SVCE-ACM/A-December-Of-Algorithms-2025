import java.util.*;

public class charusm03_mountainPeaks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++)
            heights[i] = sc.nextInt();

        List<Integer> peaks = findPeaks(heights);

        if (peaks.isEmpty())
            System.out.println("-1");
        else {
            for (int idx : peaks)
                System.out.print(idx + " ");
        }
    }

    public static List<Integer> findPeaks(int[] heights) {
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < heights.length - 1; i++) {
            if (heights[i] > heights[i - 1] && heights[i] > heights[i + 1])
                peaks.add(i);
        }
        return peaks;
    }
}
