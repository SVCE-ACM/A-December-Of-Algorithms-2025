package Dec20;
import java.util.*;
public class TowerVisibilityChallenge {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        int res[]=new int[n];
        for(int i=0;i<n;i++){
            res[i]=-1;
            for(int j=i+1;j<n;j++){
                if(a[j]>a[i]){
                    res[i]=a[j];
                    break;
                }
            }
        }
        for(int i:res){
            System.out.print(i+" ");
        }
    }
}
