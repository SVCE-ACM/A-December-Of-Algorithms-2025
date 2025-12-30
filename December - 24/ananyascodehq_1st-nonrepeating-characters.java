/*
 * Problem: First Non-Repeating Character in a String
 *
 * Approach:
 * ---------
 * 1. We need to identify the FIRST character that appears exactly once.
 * 2. Since characters are lowercase a–z, use a frequency array of size 26.
 * 3. First pass: Count frequency of each character.
 * 4. Second pass: Find first char whose frequency == 1.
 * 5. If none found → print required message.
 *
 * Why this works?
 * ---------------
 * We don’t want the smallest lexicographic character.
 * We want the first UNIQUE character in original order → so scanning twice preserves order.
 *
 * Complexity:
 * -----------
 * Time  : O(n)
 * Space : O(1) (fixed frequency array size 26)
 *
 * Constraints handled:
 * --------------------
 * ✔ Works up to 10^5 length string
 * ✔ Handles fully repeating strings
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int[] freq = new int[26];   // Frequency of each character

        // Step 1: Count frequency
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Step 2: Identify first character whose frequency is exactly 1
        for (char ch : s.toCharArray()) {
            if (freq[ch - 'a'] == 1) {
                System.out.println("The first non-repeating character is: " + ch);
                return;
            }
        }

        // Step 3: If no unique character exists
        System.out.println("No non-repeating character found.");
    }
}
