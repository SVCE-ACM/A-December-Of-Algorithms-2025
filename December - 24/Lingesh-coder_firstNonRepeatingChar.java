import java.util.*;

public class Lingesh-coder_firstNonRepeatingChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;

        boolean found = false;
        for (char c : s.toCharArray()) {
            if (count[c - 'a'] == 1) {
                System.out.println("The first non-repeating character is: " + c);
                found = true;
                break;
            }
        }
        if (!found)
            System.out.println("No non-repeating character found.");
    }
}
