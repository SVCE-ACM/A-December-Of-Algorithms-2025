import java.util.*;
public class MonishmakerSweetRewards {
    public static int sweetRewards(int n,int[] stds){
        int[] sweets = new int[n];
        Arrays.fill(sweets,1);

        for(int i=1;i<n;i++){
            if(stds[i]>stds[i-1])
                sweets[i]  = sweets[i-1]+1;
        }
        for(int i=n-2;i>=0;i--){
            if(stds[i] > stds[i+1]){
                sweets[i] = Math.max(sweets[i],sweets[i+1]+1);
            }
        }
        int tot = 0;
        for(int i=0;i<n;i++){
            tot += sweets[i];
        }
        return tot;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stds = new int[n];
        for(int i=0;i<n;i++){
            stds[i] = sc.nextInt();
        }
        System.out.println(sweetRewards(n, stds));
    }
}
 