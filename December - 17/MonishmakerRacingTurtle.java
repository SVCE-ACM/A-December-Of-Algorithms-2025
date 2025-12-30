import java.util.Scanner;
import java.util.Arrays;
public class MonishmakerRacingTurtle {
    public static int racingTurtle(int target,int[] position,int[] speed){
        int n = position.length;     
        if(n==0) return 0;

        double[][] turtles = new double[n][2];

        for(int i=0;i<n;i++){
            turtles[i][0] = position[i];
            turtles[i][1] = (double)(target-position[i]) / speed[i];
        }
        Arrays.sort(turtles,(a,b)->Double.compare(b[0],a[0]));
        int fleets = 0;
        double maxTime = 0;
        for(int i=0;i<n;i++){
            if(turtles[i][1]>maxTime){
                fleets++;
                maxTime = turtles[i][1];
            }
        }
        return fleets;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("target: ");
        int target = sc.nextInt();

        System.out.print("n: ");
        int n = sc.nextInt();

        int[] position = new int[n];
        int[]  speed = new int[n];
        
        System.out.print("position: ");
        for(int i=0;i<n;i++){
            position[i] = sc.nextInt();
        }
        System.out.print("speed: ");
        for(int i=0;i<n;i++){
            speed[i] = sc.nextInt();
        }
        int fleet = racingTurtle(target, position, speed);
        if(fleet > 0){
            System.out.println("The number of turtle fleets is: "+fleet);
        }else{
            System.out.println("No turtle fleets formed.");
        }
    }
}
