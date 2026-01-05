import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SakthiDharan01_total_of_distinct_values {
    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) {
            return;
        }
        int n = Integer.parseInt(line.trim());
        int width = Integer.toBinaryString(n).length();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            String decStr = String.format("%" + width + "d", i);
            String octStr = String.format("%" + width + "o", i);
            String hexStr = String.format("%" + width + "X", i);
            String binStr = String.format("%" + width + "s", Integer.toBinaryString(i));
            sb.append(decStr).append(' ').append(octStr).append(' ').append(hexStr).append(' ').append(binStr).append('\n');
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        solve();
    }
}
