import java.util.*;

public class SakthiDharan01_first_non_repeating_character {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String s = sc.next();
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) freq.put(c, freq.getOrDefault(c,0)+1);
        for (char c : s.toCharArray()){
            if (freq.get(c)==1){
                System.out.println("The first non-repeating character is: " + c);
                sc.close();
                return;
            }
        }
        System.out.println("No non-repeating character found.");
        sc.close();
    }
}
