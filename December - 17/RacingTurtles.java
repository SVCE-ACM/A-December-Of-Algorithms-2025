import java.util.*;

public class RacingTurtles {
    public static int countFleets(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;
        int[][] turtles = new int[n][2];
        for (int i = 0; i < n; i++) {
            turtles[i][0] = position[i];
            turtles[i][1] = speed[i];
        }
        Arrays.sort(turtles, (a, b) -> b[0] - a[0]);
        int fleets = 0;
        double lastTime = 0;

        for (int i = 0; i < n; i++) {
            double time = (double)(target - turtles[i][0]) / turtles[i][1];
            if (time > lastTime) {
                fleets++;
                lastTime = time;
            }
        }
        return fleets;
    }
}
