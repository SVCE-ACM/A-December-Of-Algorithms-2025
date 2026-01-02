import java.util.Scanner;

public class TheMissingPositiveElement {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        
        for(int x=0; x<n; x++) nums[x] = sc.nextInt();
        
        int miss = 0, dup = 0;
        
        for(int x=0; x<n; x++){
            int pos = Math.abs(nums[x]) - 1;
            if(nums[pos] < 0){
                dup = Math.abs(nums[x]);
            }
            else{
                nums[pos] = -nums[pos];
            }
        }
        
        for(int x=0; x<n; x++){
            if(nums[x] > 0){
                miss = x + 1;
                break;
            }
        }
        
        System.out.println("Missing Number: " + miss);
        System.out.println("Duplicate Number: " + dup);
        sc.close();
    }
}
