package Dec18;
import java.util.*;
public class MirrorNecklaceCheck {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        if(n==0){
            System.out.println("The necklace is empty.");
            return;
        }

        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        boolean ispalindrome=true;
        for(int i=0;i<n-1;i++){
            if(a[i]!=a[n-1-i]){
                ispalindrome=false;
            }
        }
        if(ispalindrome){
            System.out.println("The necklace is mirrored.");
        }
        else {
            System.out.println("The necklace is not mirrored.");
        }


    }
}
