import java.util.*;

public class SakthiDharan01_baseball_score_record_keeper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> ops = new ArrayList<>();
        while (sc.hasNext()) ops.add(sc.next());
        Deque<Integer> stack = new ArrayDeque<>();
        for (String op : ops) {
            switch (op) {
                case "C":
                    if (!stack.isEmpty()) stack.pop();
                    break;
                case "D":
                    if (!stack.isEmpty()) stack.push(stack.peek() * 2);
                    break;
                case "+":
                    if (stack.size() >= 2) {
                        int first = stack.pop();
                        int second = stack.peek();
                        int val = first + second;
                        stack.push(first);
                        stack.push(val);
                    }
                    break;
                default:
                    stack.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        for (int v : stack) sum += v;
        System.out.println(sum);
        sc.close();
    }
}
