import java.util.Scanner;
import java.util.Stack;

public class java_DhanaAnjana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        String[] ops = new String[n];
        for (int i = 0; i < n; i++) {
            ops[i] = scanner.next();
        }
        
        Stack<Integer> scores = new Stack<>();
        
        for (String op : ops) {
            if (op.equals("C")) {
                scores.pop();
            } else if (op.equals("D")) {
                scores.push(2 * scores.peek());
            } else if (op.equals("+")) {
                int last = scores.pop();
                int secondLast = scores.peek();
                scores.push(last);
                scores.push(last + secondLast);
            } else {
                scores.push(Integer.parseInt(op));
            }
        }
        
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        
        System.out.println(sum);
        scanner.close();
    }
}
