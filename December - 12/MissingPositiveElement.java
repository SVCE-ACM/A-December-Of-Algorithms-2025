package Dec12;
import java.util.*;
public class MissingPositiveElement {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++) {
            a[i]=s.nextInt();
        }
        Arrays.sort(a);
        for(int i=0;i<n-1;i++){
            if(a[i]+2==a[i+1])
            {
                System.out.println("Missing Number: "+ (a[i]+1));
            }
//            if(a[i+1]==a[i]+1)
//                continue;
//            else{
//                int missing = a[i]+2;
//                System.out.println("Missing Number: "+missing);
//                break;
//            }
        }
        for(int i=0;i<n-1;i++){
            if(a[i]==a[i+1]){
                System.out.println("Duplicate Number: "+a[i]);
            }
        }
    }
}
