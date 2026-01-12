import java.util.*;

public class devipriya_l_EfficientParcelSorting {
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
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int x = queue.poll();
                min = Math.min(min, x);
                queue.add(x);
            }

            boolean removed = false;
            for (int i = 0; i < size; i++) {
                int x = queue.poll();
                if (x == min && !removed) {
                    sorted.add(x);
                    removed = true;
                } else {
                    queue.add(x);
                }
            }
        }

        for (int x : sorted) {
            System.out.print(x + " ");
        }
    }
}
