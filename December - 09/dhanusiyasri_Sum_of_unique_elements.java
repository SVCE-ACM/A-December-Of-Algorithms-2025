import java.util.Scanner;
import java.util.Arrays;
public class dhanusiyasri_Sum_of_unique_elements {
    public static int sum_of_unique_elements(int[] arr){
        int sum=0;
        int count=0;
        int a=-1;
        for(int i=0;i<arr.length-1;i++){
            if(a==arr[i]){
                continue;
            }
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    count++;
                    a=arr[i];
                }
                else{
                    break;
                }
            }
            if(count==0)
                sum+=arr[i];
            count=0;
    }
    return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int sum =sum_of_unique_elements(arr);
        System.out.println(sum);
        sc.close();
    }
}
