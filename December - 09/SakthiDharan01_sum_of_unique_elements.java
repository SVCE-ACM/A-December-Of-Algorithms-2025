import java.util.*;

public class SakthiDharan01_sum_of_unique_elements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n && sc.hasNextInt(); i++) {
            int v = sc.nextInt();
            freq.put(v, freq.getOrDefault(v, 0) + 1);
        }
        long sum = 0;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            if (e.getValue() == 1) sum += e.getKey();
        }
        System.out.println(sum);
        sc.close();
    }
}
