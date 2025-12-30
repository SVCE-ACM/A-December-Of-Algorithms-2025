import java.util.Scanner;

public class Day03_BridgeCrossingChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        line = line.replaceAll("[\[\] ]", "");
        if (line.isEmpty()) { System.out.println("false"); return; }
        String[] parts = line.split(",");
        int n = parts.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(parts[i]);

        int reach = 0;
        for (int i = 0; i < n; i++) {
            if (i > reach) { System.out.println("false"); sc.close(); return; }
            reach = Math.max(reach, i + a[i]);
            if (reach >= n - 1) { System.out.println("true"); sc.close(); return; }
        }
        System.out.println(reach >= n - 1 ? "true" : "false");
        sc.close();
    }
}
