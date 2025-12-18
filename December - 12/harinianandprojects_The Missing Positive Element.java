import java.util.Scanner;

public class MissingDuplicate{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int i = 0;
        while (i < N) {
            int cind = arr[i] - 1;
            if (arr[i] != arr[cind]) {
                int t = arr[i];
                arr[i] = arr[cind];
                arr[cind] = t;
            } else {
                i++;
            }
        }

        int miss= -1, dup= -1;
        for (i = 0; i < N; i++) {
            if (arr[i] != i + 1) {
                miss= i + 1;
                dup= arr[i];
                break;
            }
        }

        System.out.println("Missing Number: " + miss);
        System.out.println("Duplicate Number: " + dup);
    }
}
