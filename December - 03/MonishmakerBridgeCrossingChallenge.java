import java.util.Scanner;
public class MonishmakerBridgeCrossingChallenge {
    public static boolean bridgeCrossingChallenge(int[] arr){
        int n = arr.length;
        int i = 0;
        while(i<n){
            if(i>=n-1)
                return true;
            if(arr[i]==0)
                return false;
            i += arr[i];
        }
        return false;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(bridgeCrossingChallenge(arr));
    }    
}
