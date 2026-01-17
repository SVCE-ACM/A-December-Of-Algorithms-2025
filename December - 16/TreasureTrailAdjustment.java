package Dec16;
import java.util.*;
public class TreasureTrailAdjustment {
    public static void main(String args[]) {
    Scanner s=new Scanner(System.in);
    int n=s.nextInt();
    ArrayList<Integer>list=new ArrayList<>();
    for(int i=0;i<n;i++){
        list.add(s.nextInt());
    }
    int k=s.nextInt();
    list.remove(n-k);
    for(int i:list){
        System.out.print(i+" ");
    }
    }

}
