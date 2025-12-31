import java.util.*;

public class devipriya_l_BaseballScoreRecordKeeper {

    public static void main(String[] args) {
        String[] ops = {"5","2","C","D","+"};
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
                stack.push(Integer.parseInt(op));
            }
        }
        int total = 0;
        for (int score : stack) {
            total += score;
        }
        System.out.println(total);
    }
}
