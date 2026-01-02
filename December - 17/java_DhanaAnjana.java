import java.util.Scanner;
import java.util.Stack;

public class java_DhanaAnjana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int target = scanner.nextInt();
        int n = scanner.nextInt();
        
        int[] position = new int[n];
        int[] speed = new int[n];
        
        for (int i = 0; i < n; i++) {
            position[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            speed[i] = scanner.nextInt();
        }
        
        if (n == 0) {
            System.out.println("No turtle fleets formed.");
            return;
        }
        
        int[][] turtles = new int[n][2];
        for (int i = 0; i < n; i++) {
            turtles[i][0] = position[i];
            turtles[i][1] = speed[i];
        }
        
        java.util.Arrays.sort(turtles, (a, b) -> b[0] - a[0]);
        
        Stack<Double> times = new Stack<>();
        int fleetCount = 0;
        
        for (int i = 0; i < n; i++) {
            double time = (double)(target - turtles[i][0]) / turtles[i][1];
            
            if (times.isEmpty() || time > times.peek()) {
                fleetCount++;
                times.push(time);
            }
        }
        
        System.out.println("The number of turtle fleets is: " + fleetCount);
        scanner.close();
    }
}
