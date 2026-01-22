import java.util.*;

public class Magesh2424_TargetSubarrayFinder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read N and K
        int N = sc.nextInt();
        long K = sc.nextLong();

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        // Map to store prefixSum -> index
        Map<Long, Integer> map = new HashMap<>();
        long sum = 0;

        // Initialize to handle subarray starting at index 0
        map.put(0L, -1);

        for (int i = 0; i < N; i++) {
            sum += arr[i];

            // Check if required prefix exists
            if (map.containsKey(sum - K)) {
                int start = map.get(sum - K) + 1;
                int end = i;
                System.out.println(start + " " + end);
                sc.close();
                return;
            }

            // Store prefix sum only if not already present
            map.putIfAbsent(sum, i);
        }

        // No subarray found
        System.out.println("-1 -1");
        sc.close();
      }
    }
