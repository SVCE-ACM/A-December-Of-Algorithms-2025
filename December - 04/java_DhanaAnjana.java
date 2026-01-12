import java.util.Scanner;

public class java_DhanaAnjana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Find subarray with sum k
        int[] result = findSubarrayWithSum(arr, k);
        System.out.println(result[0] + " " + result[1]);
        
        scanner.close();
    }
    
    static int[] findSubarrayWithSum(int[] arr, int k) {
        int[] notFound = {-1, -1};
        
        for (int i = 0; i < arr.length; i++) {
            long sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    return new int[]{i, j};
                }
            }
        }
        
        return notFound;
    }
}
