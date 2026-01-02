import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class java_DhanaAnjana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        for (char c : s.toCharArray()) {
            if (charCount.get(c) == 1) {
                System.out.println("The first non-repeating character is: " + c);
                scanner.close();
                return;
            }
        }
        
        System.out.println("No non-repeating character found.");
        scanner.close();
    }
}
