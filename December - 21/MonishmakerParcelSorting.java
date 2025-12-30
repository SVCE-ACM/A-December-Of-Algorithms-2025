import java.util.Scanner;
import java.util.Arrays;
public class MonishmakerParcelSorting {
        public static int[] sort(int[] arr){
            int n = arr.length;
            int[] sorted = new int[n];
            boolean[] used = new boolean[n];
            for(int i=0;i<n;i++){
                int min = Integer.MAX_VALUE;
                int minIndex = -1;
    
                for(int j=0;j<n;j++){
                    if(!used[j] && arr[j]<min){
                        minIndex = j;
                        min = arr[j];
                    }
                }
                sorted[i] = min;
                used[minIndex] = true;
            }
            return sorted;
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(Arrays.toString(sort(arr)));
        }
}
