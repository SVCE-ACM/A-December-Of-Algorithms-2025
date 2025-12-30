import java.util.Scanner;
public class MonishmakerFirstNonRepeating {
        public static char firstNonRepeating(String str){
            int[] hash = new int[26];
            char first ;
            for(int i=0;i<str.length();i++){
                hash[str.charAt(i)-'a'] += 1;
            }
            for(int i=0;i<str.length();i++){
                if(hash[str.charAt(i)-'a']==1){
                    first = str.charAt(i);
                    return first;
                }
            
            }
            return '\0';
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();

            char res = firstNonRepeating(str);
            if(res == '\0'){
                System.out.println("No non-repeating character found.");
            }else{
                System.out.println("The first character that appears only once is "+ res+ " .");
            }
        }
}
