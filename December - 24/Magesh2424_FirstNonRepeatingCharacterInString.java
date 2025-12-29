import java.util.*;

public class Magesh2424_FirstNonRepeatingCharacterInString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input string
        String s = sc.nextLine();

        int[] freq = new int[26];

        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Find first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                System.out.println("The first non-repeating character is: " + s.charAt(i));
                sc.close();
                return;
            }
        }

        // If no non-repeating character found
        System.out.println("No non-repeating character found.");

        sc.close();
    }
}
