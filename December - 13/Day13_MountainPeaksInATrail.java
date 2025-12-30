import java.util.*;

public class Day13_MountainPeaksInATrail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] h = new int[N]; for (int i=0;i<N;i++) h[i]=sc.nextInt();
        List<Integer> peaks = new ArrayList<>();
        for (int i=1;i<N-1;i++) if (h[i]>h[i-1] && h[i]>h[i+1]) peaks.add(i);
        if (peaks.isEmpty()) System.out.println(-1); else {for (int i=0;i<peaks.size();i++){if(i>0) System.out.print(" "); System.out.print(peaks.get(i));} System.out.println();}
        sc.close();
    }
}
