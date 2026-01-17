import java.util.Scanner;

public class MountainPeaks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] heights = new int[N];

        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }

        boolean found = false;
        for (int i = 1; i <= N - 2; i++) {
            if (heights[i] > heights[i - 1] && heights[i] > heights[i + 1]) {
                System.out.print(i + " ");
                found = true;
            }
        }

        if (!found) {
            System.out.print("-1");
        }

        sc.close();
    }
}
