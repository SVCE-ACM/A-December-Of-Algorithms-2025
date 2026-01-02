import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_DhanaAnjana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
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
            for (int i = 0; i < peaks.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(peaks.get(i));
            }
            System.out.println();
        }
        
        scanner.close();
    }
}
