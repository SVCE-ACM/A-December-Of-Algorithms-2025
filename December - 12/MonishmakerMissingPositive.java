import java.util.Scanner;
public class MonishmakerMissingPositive {
    public static void missingPositive(int[] arr , int n){
        System.out.println("Missing Number: "+missing(arr, n));
        System.out.println("Duplicate Number: "+duplicate(arr));
    }
    public static int duplicate(int[] arr){
        int slow = arr[0];
        int fast = arr[0];
        do{
            slow = arr[slow];
            fast = arr[arr[fast]];
        }while(slow!=fast);
        slow = arr[0];
        while(slow != fast){
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }
    public static int missing(int[] arr,int n){
        int sum = 0;
        for(int num:arr){
            sum += num;
        }
        int dup = duplicate(arr);
        int expectedSum = (n*(n+1)) / 2;
        return (expectedSum + dup) - sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        missingPositive(arr,n);
    }
}
