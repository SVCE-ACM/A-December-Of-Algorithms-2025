import java.util.*;

public class Day24_FirstNonRepeatingCharacter {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next(); int n=s.length(); int[] freq=new int[26]; for(char c:s.toCharArray()) freq[c-'a']++;
        char ans=0; for(char c:s.toCharArray()) if(freq[c-'a']==1){ans=c; break;}
        if(ans==0) System.out.println("No non-repeating character found."); else System.out.println("The first non-repeating character is: " + ans);
        sc.close();
    }
}
