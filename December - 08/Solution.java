import java.util.*;
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        Stack<Integer> stack = new Stack<>();
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            stack.push(sandwiches[i]);
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i : students) queue.offerLast(i);

        int rotations = 0;

        while (!stack.isEmpty() && !queue.isEmpty()) {
            int stackTop = stack.peek();
            int queueTop = queue.peekFirst();

            if (stackTop == queueTop) {
                stack.pop();
                queue.pollFirst();
                rotations = 0; 
            } else {
                queue.offerLast(queue.pollFirst());
                rotations++;
            }

            if (rotations == queue.size()) {
                return stack.size();
            }
        }

        return 0;
    }
}
