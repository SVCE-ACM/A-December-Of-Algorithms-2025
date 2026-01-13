import java.util.*;

public class Lingesh-coder_efficientParcelSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++)
            queue.add(sc.nextInt());

        List<Integer> sorted = new ArrayList<>();
        while (!queue.isEmpty()) {
            int min = Collections.min(queue);
            while (queue.peek() != min) {
                queue.add(queue.poll());
            }
            sorted.add(queue.poll());
        }

        for (int i = 0; i < sorted.size(); i++) {
            System.out.print(sorted.get(i));
            if (i != sorted.size() - 1)
                System.out.print(" ");
        }
    }
}
