import java.util.*;

public class devipriya_l_FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        for (char c : s.toCharArray()) {
            if (freq[c - 'a'] == 1) {
                System.out.println("The first non-repeating character is: " + c);
                return;
            }
        }
        System.out.println("No non-repeating character found.");
    }
}
