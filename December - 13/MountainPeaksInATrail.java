package Dec13;
import java.util.*;
public class MountainPeaksInATrail {
    public static void main(String args[]) {
    Scanner s=new Scanner(System.in);
    int n=s.nextInt();
    int flag=0;
    int a[]=new int[n];
    for(int i=0;i<n;i++) {
        a[i]=s.nextInt();
    }
    for(int i=1;i<n-1;i++){
        if((a[i-1]<a[i])&&(a[i]>a[i+1])){
            System.out.print(i+" ");
            flag=1;
        }
    }
    if(flag==0){
        System.out.println("-1");
    }
    }

}
