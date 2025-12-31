import java.util.Scanner;

public class MissingAndDuplicate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] arr = new long[N];

        long actualSum = 0;
        long actualSqSum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
            actualSum += arr[i];
            actualSqSum += arr[i] * arr[i];
        }

        long expectedSum = (long) N * (N + 1) / 2;
        long expectedSqSum = (long) N * (N + 1) * (2L * N + 1) / 6;

        long diff = expectedSum - actualSum;
        long sqDiff = expectedSqSum - actualSqSum;
        long sumMD = sqDiff / diff;

        long missing = (diff + sumMD) / 2;
        long duplicate = sumMD - missing;

        System.out.println("Missing Number: " + missing);
        System.out.println("Duplicate Number: " + duplicate);

        sc.close();
    }
}
