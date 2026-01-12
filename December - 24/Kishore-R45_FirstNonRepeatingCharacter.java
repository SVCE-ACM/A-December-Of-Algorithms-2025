import java.util.Scanner;

public class FirstNonRepeatingCharacter {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        
        int[] count = new int[26];
        
        for(int x=0; x<str.length(); x++){
            count[str.charAt(x) - 'a']++;
        }
        
        for(int x=0; x<str.length(); x++){
            char ch = str.charAt(x);
            if(count[ch - 'a'] == 1){
                System.out.println("The first non-repeating character is: " + ch);
                return;
            }
        }
        
        System.out.println("No non-repeating character found.");
        sc.close();
    }
}
