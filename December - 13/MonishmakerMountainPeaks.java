import java.util.ArrayList;
import java.util.Scanner;
public class MonishmakerMountainPeaks {
    public static ArrayList<Integer> mountainPeaks(int[] arr,int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<n-1;i++){
            if(arr[i-1]<arr[i]&&arr[i]>arr[i+1]){
                list.add(i);
            }
        
        }
        if(list.isEmpty()){
            list.add(-1);
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print(mountainPeaks(arr, n));
    }
}
