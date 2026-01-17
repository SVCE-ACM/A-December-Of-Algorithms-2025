import java.util.*;

public class SakthiDharan01_perfect_squares_counter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLong()) {
            return;
        }
        long n = sc.nextLong();
        if (n < 1) {
            System.out.println();
            System.out.println(0);
            return;
        }
        long limit = (long) Math.sqrt(n);
        List<Long> squares = new ArrayList<>();
        for (long i = 1; i <= limit; i++) {
            long sq = i * i;
            if (sq <= n) squares.add(sq);
        }
        if (!squares.isEmpty()) {
            for (int i = 0; i < squares.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(squares.get(i));
            }
        }
        System.out.println();
        System.out.println(squares.size());
        sc.close();
    }
}
