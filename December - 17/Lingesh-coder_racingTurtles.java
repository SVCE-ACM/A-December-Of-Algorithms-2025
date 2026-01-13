import java.util.*;

public class Lingesh-coder_racingTurtles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int target = sc.nextInt();
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("No turtle fleets formed.");
            return;
        }

        int[] pos = new int[n];
        int[] speed = new int[n];

        for (int i = 0; i < n; i++)
            pos[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            speed[i] = sc.nextInt();

        int fleets = countTurtleFleets(target, pos, speed);
        System.out.println("The number of turtle fleets is: " + fleets);
    }

    public static int countTurtleFleets(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] turtles = new int[n][2];

        for (int i = 0; i < n; i++) {
            turtles[i][0] = position[i];
            turtles[i][1] = speed[i];
        }

        Arrays.sort(turtles, (a, b) -> b[0] - a[0]);

        double lastTime = -1;
        int fleets = 0;

        for (int i = 0; i < n; i++) {
            double time = (double) (target - turtles[i][0]) / turtles[i][1];
            if (time > lastTime) {
                fleets++;
                lastTime = time;
            }
        }

        return fleets;
    }
}
