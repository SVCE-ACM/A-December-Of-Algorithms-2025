import java.util.Arrays;
import java.util.Scanner;

public class SumOfUniqueElements {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        long sum = 0;

        for (int i = 0; i < N; i++) {
            boolean isUnique = true;

            if (i > 0 && arr[i] == arr[i - 1]) {
                isUnique = false;
            }

            if (i < N - 1 && arr[i] == arr[i + 1]) {
                isUnique = false;
            }

            if (isUnique) {
                sum += arr[i];
            }
        }

        System.out.println(sum);
        sc.close();
    }
}
