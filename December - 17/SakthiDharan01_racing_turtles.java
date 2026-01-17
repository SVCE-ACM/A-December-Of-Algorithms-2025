import java.util.*;

public class SakthiDharan01_racing_turtles {
    private static class Turtle {
        int pos, speed;
        Turtle(int p,int s){pos=p;speed=s;}
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int target = sc.nextInt();
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] pos = new int[n];
        int[] speed = new int[n];
        for (int i=0;i<n && sc.hasNextInt();i++) pos[i]=sc.nextInt();
        for (int i=0;i<n && sc.hasNextInt();i++) speed[i]=sc.nextInt();
        if (n==0){
            System.out.println("No turtle fleets formed.");
            return;
        }
        Turtle[] arr = new Turtle[n];
        for (int i=0;i<n;i++) arr[i]=new Turtle(pos[i], speed[i]);
        Arrays.sort(arr, (a,b)->b.pos-a.pos);
        int fleets=0;
        double slow=-1;
        for (Turtle t: arr){
            double time = (double)(target - t.pos) / t.speed;
            if (time > slow){
                fleets++;
                slow = time;
            }
        }
        System.out.println("The number of turtle fleets is: " + fleets);
        sc.close();
    }
}
