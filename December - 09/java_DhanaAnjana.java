import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class java_DhanaAnjana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        
        long sum = 0;
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == 1) {
                sum += entry.getKey();
            }
        }
        
        System.out.println(sum);
        scanner.close();
    }
}
