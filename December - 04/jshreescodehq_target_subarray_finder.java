import java.util.Scanner;

public class TargetSubarrayFinderBrute {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long K = sc.nextLong();

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        boolean found = false;
      
        for (int i = 0; i < N; i++) {                 
            long sum = 0;

            for (int j = i; j < N; j++) {
                sum += arr[j];
              
                if (sum == K) {
                    System.out.println(i + " " + j);
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        if (!found) {
            System.out.println("-1 -1");
        }

        sc.close();
    }
}

