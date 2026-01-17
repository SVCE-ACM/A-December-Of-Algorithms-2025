package Dec17;
import java.util.*;
public class RacingTurtles {
        static class Turtle {
            int position;
            double time;

            Turtle(int position, double time) {
                this.position = position;
                this.time = time;
            }
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // Read inputs
            int target = sc.nextInt();
            int n = sc.nextInt();

            if (n == 0) {
                System.out.println("No turtle fleets formed.");
                return;
            }
            int[] position = new int[n];
            int[] speed = new int[n];

            for (int i = 0; i < n; i++) {
                position[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                speed[i] = sc.nextInt();
            }

            // Create turtle list
            Turtle[] turtles = new Turtle[n];
            for (int i = 0; i < n; i++) {
                double time = (double)(target - position[i]) / speed[i];
                turtles[i] = new Turtle(position[i], time);
            }

            // Sort by position descending
            Arrays.sort(turtles, (a, b) -> b.position - a.position);

            int fleets = 0;
            double maxTime = 0;

            // Count fleets
            for (Turtle t : turtles) {
                if (t.time > maxTime) {
                    fleets++;
                    maxTime = t.time;
                }
            }

            System.out.println("The number of turtle fleets is: " + fleets);
        }
    }


