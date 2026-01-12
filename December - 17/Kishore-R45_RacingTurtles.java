import java.util.*;

public class RacingTurtles {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int finish = sc.nextInt();
        int count = sc.nextInt();
        
        if(count == 0){
            System.out.println("No turtle fleets formed.");
            return;
        }
        
        int[] pos = new int[count];
        int[] spd = new int[count];
        
        for(int x=0; x<count; x++) pos[x] = sc.nextInt();
        for(int x=0; x<count; x++) spd[x] = sc.nextInt();
        
        double[][] info = new double[count][2];
        for(int x=0; x<count; x++){
            info[x][0] = pos[x];
            info[x][1] = (double)(finish - pos[x]) / spd[x];
        }
        
        Arrays.sort(info, (a, b) -> Double.compare(b[0], a[0]));
        
        int fleets = 0;
        double slowest = 0;
        
        for(int x=0; x<count; x++){
            double t = info[x][1];
            if(t > slowest){
                fleets++;
                slowest = t;
            }
        }
        
        System.out.println("The number of turtle fleets is: " + fleets);
        sc.close();
    }
}
