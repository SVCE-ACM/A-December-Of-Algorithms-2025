import java.util.*;

public class MissingAndDuplicateNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int i = 0;
        while (i < N) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                i++;
            }
        }
        int missing = -1;
        int duplicate = -1;

        for (i = 0; i < N; i++) {
            if (arr[i] != i + 1) {
                missing = i + 1;
                duplicate = arr[i];
                break;
            }
        }
        System.out.println("Missing Number: " + missing);
        System.out.println("Duplicate Number: " + duplicate);
        sc.close();
    }
}
