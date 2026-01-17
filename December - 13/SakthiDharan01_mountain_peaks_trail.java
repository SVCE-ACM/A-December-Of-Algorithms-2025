import java.util.*;

public class SakthiDharan01_mountain_peaks_trail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n && sc.hasNextInt(); i++) h[i] = sc.nextInt();
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < n - 1; i++) {
            if (h[i] > h[i-1] && h[i] > h[i+1]) res.add(i);
        }
        if (res.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < res.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(res.get(i));
            }
        }
        sc.close();
    }
}
