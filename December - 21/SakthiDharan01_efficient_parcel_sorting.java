import java.util.*;

public class SakthiDharan01_efficient_parcel_sorting {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        Deque<Integer> q = new ArrayDeque<>();
        for (int i=0;i<n && sc.hasNextInt();i++) q.addLast(sc.nextInt());
        List<Integer> output = new ArrayList<>();
        while (!q.isEmpty()){
            int min = Integer.MAX_VALUE;
            for (int v : q) min = Math.min(min, v);
            int idx = 0;
            for (int v : q){
                if (v == min) break;
                idx++;
            }
            for (int i=0;i<idx;i++) q.addLast(q.pollFirst());
            output.add(q.pollFirst());
        }
        for (int i=0;i<output.size();i++){
            if (i>0) System.out.print(" ");
            System.out.print(output.get(i));
        }
        sc.close();
    }
}
