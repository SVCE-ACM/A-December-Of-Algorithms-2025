import java.util.*;

public class charusm03_towerVisibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] heights = new int[N];
        for (int i = 0; i < N; i++)
            heights[i] = sc.nextInt();

        int[] result = new int[N];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                result[stack.pop()] = heights[i];
            }
            stack.push(i);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(result[i]);
            if (i != N - 1)
                System.out.print(" ");
        }
    }
}
