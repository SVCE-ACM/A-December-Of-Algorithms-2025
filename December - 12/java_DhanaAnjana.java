import java.util.Scanner;

public class java_DhanaAnjana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        int missing = 0, duplicate = 0;
        
        for (int i = 0; i < n; i++) {
            int num = Math.abs(arr[i]);
            if (arr[num - 1] < 0) {
                duplicate = num;
            } else {
                arr[num - 1] = -arr[num - 1];
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                missing = i + 1;
                break;
            }
        }
        
        System.out.println("Missing Number: " + missing);
        System.out.println("Duplicate Number: " + duplicate);
        
        scanner.close();
    }
}
