import java.util.*;

public class Lingesh-coder_cafeteriaQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] students = new int[n];
        int[] sandwiches = new int[n];

        for (int i = 0; i < n; i++)
            students[i] = sc.nextInt();

        for (int i = 0; i < n; i++)
            sandwiches[i] = sc.nextInt();

        System.out.println(countStudents(students, sandwiches));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        for (int s : students)
            queue.add(s);

        int index = 0;
        int rotations = 0;

        while (!queue.isEmpty() && rotations < queue.size()) {
            if (queue.peek() == sandwiches[index]) {
                queue.poll();
                index++;
                rotations = 0;
            } else {
                queue.add(queue.poll());
                rotations++;
            }
        }

        return queue.size();
    }
}
