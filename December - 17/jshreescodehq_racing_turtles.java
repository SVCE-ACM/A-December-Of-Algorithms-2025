import java.util.Arrays;

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

        int target = 12;
        int n = 5;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};

        if (n == 0) {
            System.out.println("No turtle fleets formed.");
            return;
        }

        Turtle[] turtles = new Turtle[n];

        for (int i = 0; i < n; i++) {
            double time = (double) (target - position[i]) / speed[i];
            turtles[i] = new Turtle(position[i], time);
        }

        Arrays.sort(turtles, (a, b) -> b.position - a.position);

        int fleets = 0;
        double maxTime = 0;

        for (Turtle t : turtles) {
            if (t.time > maxTime) {
                fleets++;
                maxTime = t.time;
            }
        }

        System.out.println("The number of turtle fleets is: " + fleets);
    }
}
