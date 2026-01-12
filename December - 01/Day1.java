import java.util.*;
public class Day1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i * i <= n; i++) {
            if (cnt > 0) sb.append(" ");
            sb.append(i * i);
            cnt++;
        }
        
        System.out.println(sb.toString());
        System.out.println(cnt);
    }
}