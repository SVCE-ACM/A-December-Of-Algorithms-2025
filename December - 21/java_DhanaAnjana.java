import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class java_DhanaAnjana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] weights = new int[n];
        
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int w : weights) {
            queue.add(w);
        }
        
        StringBuilder result = new StringBuilder();
        
        while (!queue.isEmpty()) {
            int minWeight = findMin(queue);
            int rotations = rotateToFront(queue, minWeight);
            queue.poll();
            
            if (result.length() > 0) result.append(" ");
            result.append(minWeight);
        }
        
        System.out.println(result.toString());
        scanner.close();
    }
    
    static int findMin(Queue<Integer> queue) {
        int min = Integer.MAX_VALUE;
        for (int w : queue) {
            min = Math.min(min, w);
        }
        return min;
    }
    
    static int rotateToFront(Queue<Integer> queue, int target) {
        int rotations = 0;
        while (queue.peek() != target) {
            queue.add(queue.poll());
            rotations++;
        }
        return rotations;
    }
}
