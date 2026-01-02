import java.util.Scanner;
import java.util.Stack;

public class java_DhanaAnjana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] heights = new int[n];
        
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }
        
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.pop();
            }
            
            result[i] = stack.isEmpty() ? -1 : heights[stack.peek()];
            stack.push(i);
        }
        
        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(result[i]);
        }
        System.out.println();
        
        scanner.close();
    }
}
