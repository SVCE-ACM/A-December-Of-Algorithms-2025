import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            q.add(sc.nextInt());
        }

        List<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            // Find minimum element
            int minVal = Integer.MAX_VALUE;
            for (int x : q) minVal = Math.min(minVal, x);

            // Find index of minimum
            int idx = 0;
            for (int x : q) {
                if (x == minVal) break;
                idx++;
            }

            // Rotate idx times (front to back)
            for (int i = 0; i < idx; i++) {
                q.addLast(q.pollFirst());
            }

            // Remove min to output
            result.add(q.pollFirst());
        }

        // Print sorted result
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
