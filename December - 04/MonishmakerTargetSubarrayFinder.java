import java.util.Scanner;
import java.util.Arrays;

public class MonishmakerTargetSubarrayFinder {
    public static int[] targetSubarrayFinder(int n,int t,int[] arr){
        int start=0,sum=0;
        for(int end = 0;end<n;end++){
            sum += arr[end];

            while(sum > t && start <= end){
                sum -= arr[start++];
            }
            if(sum == t){
                return new int[] {start,end};
            }
        }
        return new int[] {-1,-1};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(targetSubarrayFinder(n,t,arr)));
    }
}
