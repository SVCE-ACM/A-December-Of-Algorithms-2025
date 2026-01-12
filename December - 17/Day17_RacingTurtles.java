import java.util.*;

public class Day17_RacingTurtles {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int target=sc.nextInt(); int n=sc.nextInt();
        int[] pos=new int[n]; int[] sp=new int[n]; for(int i=0;i<n;i++) pos[i]=sc.nextInt(); for(int i=0;i<n;i++) sp[i]=sc.nextInt();
        Integer[] idx=new Integer[n]; for(int i=0;i<n;i++) idx[i]=i;
        Arrays.sort(idx,(a,b)->Integer.compare(pos[b],pos[a]));
        int fleets=0; double curTime=-1;
        for(int id:idx){ double t=(double)(target-pos[id])/sp[id]; if(t>curTime){fleets++; curTime=t;} }
        if(n==0) System.out.println("No turtle fleets formed."); else System.out.println("The number of turtle fleets is: " + fleets);
        sc.close();
    }
}
