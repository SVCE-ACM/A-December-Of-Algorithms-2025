package Dec08;
import java.util.*;
public class CafeteriaQueue {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int students[] = new int[n];
        int sandwich[] = new int[n];
        for (int i = 0; i < n; i++) {
            students[i] = s.nextInt();
        }
        for(int i=0;i<n;i++){
            sandwich[i]=s.nextInt();
        }
        int count0=0;
        int count1=0;
        for(int i:students){
            if(i==0)
                count0++;
            else count1++;
        }
        for(int i=0;i<n;i++){
            if(sandwich[i]==0){
                if(count0==0)
                    break;
                count0--;
            }
            else{
                if(count1==0)
                    break;
                count1--;
            }
        }
        System.out.println(count0+count1);
    }
}
