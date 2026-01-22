import java.util.*;

public class Magesh2424_SumOfUniqueElements {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read array size
        int N = sc.nextInt();

        // Frequency map
        Map<Long, Integer> freqMap = new HashMap<>();

        // Read elements and count frequency
        for (int i = 0; i < N; i++) {
            long num = sc.nextLong();
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        long sum = 0;

        // Sum elements that appear exactly once
        for (Map.Entry<Long, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                sum += entry.getKey();
            }
        }

        // Output result
        System.out.println(sum);

        sc.close();
    }
}
