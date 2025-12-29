import java.util.*;

public class Magesh2424_TowerVisibilityChallenge {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of towers
        int N = sc.nextInt();

        int[] heights = new int[N];
        int[] result = new int[N];

        // Read heights
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
            result[i] = -1; // default value
        }

        Stack<Integer> stack = new Stack<>();

        // Traverse towers
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = heights[i];
            }
            stack.push(i);
        }

        // Print result
        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + " ");
        }

        sc.close();
    }
}
