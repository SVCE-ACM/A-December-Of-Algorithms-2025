import java.util.*;

public class SakthiDharan01_zig_zag_linked_list {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n && sc.hasNextInt(); i++) arr[i] = sc.nextInt();
        List<Integer> res = new ArrayList<>();
        int l = 0, r = n - 1;
        boolean toggle = true;
        while (l <= r) {
            if (toggle) res.add(arr[l++]);
            else res.add(arr[r--]);
            toggle = !toggle;
        }
        for (int i = 0; i < res.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(res.get(i));
        }
        sc.close();
    }
}
