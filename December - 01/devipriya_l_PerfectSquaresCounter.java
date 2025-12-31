import java.util.*;

public class devipriya_l_PerfectSquaresCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int count = 0;

        StringBuilder sb = new StringBuilder();

        int i = 1;
        while (i * i <= N) {
            sb.append(i * i).append(" ");
            count++;
            i++;
        }
        if (sb.length() > 0) {
            System.out.println(sb.toString().trim());
        } else {
            System.out.println();
        }
        System.out.println(count);

        sc.close();
    }
}
