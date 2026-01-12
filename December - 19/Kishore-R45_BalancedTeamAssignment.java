import java.util.Scanner;

public class BalancedTeamAssignment {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] skill = new int[n];
        int sum = 0;
        
        for(int x=0; x<n; x++){
            skill[x] = sc.nextInt();
            sum += skill[x];
        }
        
        int half = sum / 2;
        boolean[] possible = new boolean[half + 1];
        possible[0] = true;
        
        for(int x=0; x<n; x++){
            for(int y=half; y>=skill[x]; y--){
                if(possible[y - skill[x]]){
                    possible[y] = true;
                }
            }
        }
        
        int best = 0;
        for(int x=half; x>=0; x--){
            if(possible[x]){
                best = x;
                break;
            }
        }
        
        int diff = sum - 2*best;
        System.out.println(diff);
        sc.close();
    }
}
