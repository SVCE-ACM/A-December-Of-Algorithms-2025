import java.util.*;

public class Magesh2424_EfficientParcelSorting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of parcels
        int N = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        // Read parcel weights
        for (int i = 0; i < N; i++) {
            queue.offer(sc.nextInt());
        }

        List<Integer> sorted = new ArrayList<>();

        // Simulate sorting
        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = Integer.MAX_VALUE;

            // Find minimum element in queue
            for (int i = 0; i < size; i++) {
                int x = queue.poll();
                min = Math.min(min, x);
                queue.offer(x);
            }

            // Rotate queue until min comes to front
            boolean removed = false;
            for (int i = 0; i < size; i++) {
                int x = queue.poll();
                if (!removed && x == min) {
                    sorted.add(x); // Pick and place
                    removed = true;
                } else {
                    queue.offer(x); // Rotate
                }
            }
        }

        // Print sorted result
        for (int val : sorted) {
            System.out.print(val + " ");
        }

        sc.close();
    }
}
