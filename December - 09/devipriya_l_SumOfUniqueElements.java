import java.util.*;

public class devipriya_l_SumOfUniqueElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        HashMap<Long, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            long num = sc.nextLong();
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        long sum = 0;
        for (Map.Entry<Long, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                sum += entry.getKey();
            }
        }
        System.out.println(sum);
        sc.close();
    }
}
