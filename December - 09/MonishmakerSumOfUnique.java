import java.util.Scanner;
import java.util.HashMap;
public class MonishmakerSumOfUnique {
    public static long sumOfUnique(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        long sum = 0;

        for(int num:arr){
            if(map.get(num)==1)
                sum +=num;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        System.out.println(sumOfUnique(arr));
    }
}
