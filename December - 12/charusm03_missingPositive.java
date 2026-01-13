import java.util.*;

public class charusm03_missingPositive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int[] result = findMissingAndDuplicate(arr);
        System.out.println("Missing Number: " + result[0]);
        System.out.println("Duplicate Number: " + result[1]);
    }

    public static int[] findMissingAndDuplicate(int[] arr) {
        int n = arr.length;
        int i = 0;

        while (i < n) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else {
                i++;
            }
        }

        int missing = -1, duplicate = -1;
        for (i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                missing = i + 1;
                duplicate = arr[i];
                break;
            }
        }

        return new int[] { missing, duplicate };
    }
}
