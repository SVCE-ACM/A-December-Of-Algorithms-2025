package Dec24;
import java.util.*;
public class nonRepeatingCharacter {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();

            boolean found = false;

            for (int i = 0; i < s.length(); i++) {
                char current = s.charAt(i);
                int count = 0;

                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == current) {
                        count++;
                    }
                }

                if (count == 1) {
                    System.out.println("The first non-repeating character is: " + current);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("No non-repeating character found.");
            }
        }
    }

