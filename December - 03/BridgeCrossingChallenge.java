package Dec03;
import java.util.*;
public class BridgeCrossingChallenge {
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=s.nextInt();
        }
        int max_reachable=0;
        int i=0;
        int flag=0;


        while(i<n)
        {
          if(a[i]==0&&i==0)
              break;
          else if(a[i]==0 && flag==0){
              --i;
              flag=1;
              continue;
          }
          else if(a[i]==0 && flag==1){
              break;
          }

          if((a[i]+i)>max_reachable){
              max_reachable=a[i]+i;
          }
          i=i+a[i];
        }
        //System.out.println("Value of i:"+ i);
        //System.out.println("Max reachable: "+max_reachable);
        if(max_reachable >= n-1){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
}
