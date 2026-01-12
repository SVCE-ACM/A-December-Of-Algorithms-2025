import java.util.Scanner;

public class dhanusiyasri_first_non_repeating_character {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        int[] visited = new int[input.length()];
        boolean flag = true;
        for(int i=0;i<input.length();i++){
            if(visited[i] == 1){
                continue;
            }
            for(int j=i+1;j<input.length();j++){
                if(input.charAt(i) == input.charAt(j)){
                    visited[j] = 1;
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("The first non-repeating character is: "+input.charAt(i));
                return;
            }
            flag = true;
        }
        System.out.println("No non-repeating character found.");
    }
}
