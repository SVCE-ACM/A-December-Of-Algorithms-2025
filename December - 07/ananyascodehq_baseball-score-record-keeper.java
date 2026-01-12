import java.util.*;
/*
 * Problem: Baseball Score Record Keeper
 * Approach:
 *   - Use a stack to track score history.
 *   - For each operation:
 *       "C": remove last score.
 *       "D": duplicate last score * 2.
 *       "+": sum of last two scores.
 *       else: push integer score.
 *   - Compute sum of all remaining values in the stack.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for (String op : ops) {

            if (op.equals("C")) {
                stack.pop();
            
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            
            } else if (op.equals("+")) {
                int a = stack.peek();
                int b = stack.get(stack.size() - 2);
                stack.push(a + b);
            
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for (int val : stack) sum += val;

        return sum;
    }
}
