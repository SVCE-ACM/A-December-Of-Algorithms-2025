import java.util.*;

public class Magesh2424_BaseballScoreRecordKeeper {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of operations
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] ops = new String[n];

        // Read operations
        for (int i = 0; i < n; i++) {
            ops[i] = sc.nextLine();
        }

        Stack<Integer> stack = new Stack<>();

        for (String op : ops) {
            if (op.equals("C")) {
                stack.pop();
            } 
            else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } 
            else if (op.equals("+")) {
                int top = stack.pop();
                int newScore = top + stack.peek();
                stack.push(top);
                stack.push(newScore);
            } 
            else {
                // Integer value
                stack.push(Integer.parseInt(op));
            }
        }

        // Calculate total score
        int sum = 0;
        for (int score : stack) {
            sum += score;
        }

        // Output result
        System.out.println(sum);
        sc.close();
    }
}
