import java.util.*;

public class charusm03_targetSubarrayFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        findSubarray(arr, k);
    }

    public static void findSubarray(int[] arr, int k) {
        HashMap<Long, Integer> map = new HashMap<>();
        long sum = 0;

        map.put(0L, -1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum - k)) {
                System.out.println((map.get(sum - k) + 1) + " " + i);
                return;
            }

            if (!map.containsKey(sum))
                map.put(sum, i);
        }

        System.out.println("-1 -1");
    }
}
