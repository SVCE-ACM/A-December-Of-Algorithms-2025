import java.util.*;

class MissingAndDuplicate {

    public static void findMissingAndDuplicate(int[] arr) {
        int n = arr.length;
        int i = 0;

        // Cyclic sort
        while (i < n) {
            int correctIdx = arr[i] - 1;
            if (arr[i] != arr[correctIdx]) {
                int temp = arr[i];
                arr[i] = arr[correctIdx];
                arr[correctIdx] = temp;
            } else {
                i++;
            }
        }

        // Identify missing and duplicate
        for (i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                System.out.println("Missing Number: " + (i + 1));
                System.out.println("Duplicate Number: " + arr[i]);
                return;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        findMissingAndDuplicate(arr);
    }
}
