import java.util.*;

public class SakthiDharan01_missing_positive_element {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSq = (long) n * (n + 1) * (2L * n + 1) / 6;
        long actualSum = 0;
        long actualSq = 0;
        for (int i = 0; i < n && sc.hasNextInt(); i++) {
            long v = sc.nextLong();
            actualSum += v;
            actualSq += v * v;
        }
        long diff = expectedSum - actualSum; // missing - duplicate
        long diffSq = expectedSq - actualSq; // (m-d)(m+d)
        long sum = diffSq / diff; // missing + duplicate
        long missing = (diff + sum) / 2;
        long duplicate = missing - diff;
        System.out.println("Missing Number: " + missing);
        System.out.println("Duplicate Number: " + duplicate);
        sc.close();
    }
}
