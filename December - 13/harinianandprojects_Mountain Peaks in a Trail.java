import java.util.*;
public class MountainPeak{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i <n; i++) 
        {
            arr[i] = sc.nextInt();
        }

        boolean peak = false;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                System.out.print(i + " ");
                peak = true;
            }
        }

        if (!peak) System.out.print(-1);
    }
}
