import java.util.Scanner;

public class SweetRewardsForStudents {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rating = new int[n];
        
        for(int x=0; x<n; x++) rating[x] = sc.nextInt();
        
        int[] candy = new int[n];
        for(int x=0; x<n; x++) candy[x] = 1;
        
        for(int x=1; x<n; x++){
            if(rating[x] > rating[x-1]){
                candy[x] = candy[x-1] + 1;
            }
        }
        
        for(int x=n-2; x>=0; x--){
            if(rating[x] > rating[x+1]){
                if(candy[x] <= candy[x+1]){
                    candy[x] = candy[x+1] + 1;
                }
            }
        }
        
        int sum = 0;
        for(int x=0; x<n; x++) sum += candy[x];
        
        System.out.println(sum);
        sc.close();
    }
}
