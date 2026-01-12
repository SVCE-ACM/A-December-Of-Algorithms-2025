import java.util.Scanner;
import java.util.Queue;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
public class dhanusiyasri_efficient_parcel_sorting {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Queue<Integer> items=new LinkedList<>();
        for(int i=0;i<n;i++){
            items.add(sc.nextInt());
        }
        List<Integer> sortedItems=new LinkedList<>(items);
        Collections.sort(sortedItems);
        for(int item:sortedItems){
            System.out.print(item+" ");
        }
        sc.close();
    }
}
