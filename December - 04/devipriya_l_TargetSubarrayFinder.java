import java.util.*;

public class devipriya_l_TargetSubarrayFinder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long K = sc.nextLong();

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);

        long sum = 0;

        for (int i = 0; i < N; i++) {
            sum += arr[i];

            if (map.containsKey(sum - K)) {
                int start = map.get(sum - K) + 1;
                int end = i;
                System.out.println(start + " " + end);
                sc.close();
                return;
            }

            map.putIfAbsent(sum, i);
        }
        System.out.println("-1 -1");
        sc.close();
    }
}
