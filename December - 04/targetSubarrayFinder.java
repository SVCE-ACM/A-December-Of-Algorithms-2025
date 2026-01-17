package Dec04;
import java.util.*;
public class targetSubarrayFinder {
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int k=s.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        int sum=0;
        for(int i=0;i<n;i++){
            int st=i;
            sum+=a[i];
            if(sum<k){
                continue;
            }
        }

    }

}
