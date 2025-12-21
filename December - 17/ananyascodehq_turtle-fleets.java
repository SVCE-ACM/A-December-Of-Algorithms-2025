import java.util.*;

class Solution {
    public int turtleFleets(int target, int[] position, int[] speed) {
        int n = position.length;
        if(n == 0) return 0;

        double[][] turtles = new double[n][2];

        for(int i = 0; i < n; i++){
            turtles[i][0] = position[i];
            turtles[i][1] = (double)(target - position[i]) / speed[i];
        }

        Arrays.sort(turtles, (a, b) -> Double.compare(a[0], b[0]));

        int fleets = 0;
        double maxTime = 0;

        for(int i = n - 1; i >= 0; i--){
            double time = turtles[i][1];
            if(time > maxTime){
                fleets++;
                maxTime = time;
            }
        }
        return fleets;
    }
}
