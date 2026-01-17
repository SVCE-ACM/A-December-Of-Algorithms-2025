import java.util.*;

public class EfficientParcelSorting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            queue.add(sc.nextInt());
        }

        List<Integer> sorted = new ArrayList<>();
        while (!queue.isEmpty()) {
            int min = Integer.MAX_VALUE;
            for (int val : queue) {
                if (val < min) {
                    min = val;
                }
            }
            while (queue.peek() != min) {
                queue.add(queue.poll()); 
            }

            sorted.add(queue.poll());
        }
        for (int val : sorted) {
            System.out.print(val + " ");
        }

        sc.close();
    }
}
