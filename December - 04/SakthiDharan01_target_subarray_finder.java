import java.util.*;

public class SakthiDharan01_target_subarray_finder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        while (sc.hasNextInt()) nums.add(sc.nextInt());
        if (nums.size() < 3) return;
        int n = nums.get(0);
        long k = nums.get(1);
        int[] arr = new int[n];
        for (int i = 0; i < n && 2 + i < nums.size(); i++) arr[i] = nums.get(2 + i);

        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, -1);
        long curr = 0;
        int resL = -1, resR = -1;
        for (int i = 0; i < n; i++) {
            curr += arr[i];
            long need = curr - k;
            if (prefix.containsKey(need)) {
                resL = prefix.get(need) + 1;
                resR = i;
                break;
            }
            prefix.putIfAbsent(curr, i);
        }
        System.out.println(resL + " " + resR);
        sc.close();
    }
}
