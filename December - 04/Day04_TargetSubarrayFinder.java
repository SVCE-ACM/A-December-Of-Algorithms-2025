import java.util.*;

public class Day04_TargetSubarrayFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long K = sc.nextLong();
        long[] a = new long[N];
        for (int i = 0; i < N; i++) a[i] = sc.nextLong();

        Map<Long,Integer> pref = new HashMap<>();
        pref.put(0L, -1);
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += a[i];
            if (pref.containsKey(sum - K)) {
                System.out.println((pref.get(sum - K) + 1) + " " + i);
                sc.close();
                return;
            }
            pref.put(sum, i);
        }
        System.out.println("-1 -1");
        sc.close();
    }
}
