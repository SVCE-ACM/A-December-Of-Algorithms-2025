import java.util.*;

public class Magesh2424_SweetRewardsForStudents {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of students
        int n = sc.nextInt();

        int[] scores = new int[n];

        // Read performance scores
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        // Each student gets at least one sweet
        int[] sweets = new int[n];
        Arrays.fill(sweets, 1);

        // Left to right pass
        for (int i = 1; i < n; i++) {
            if (scores[i] > scores[i - 1]) {
                sweets[i] = sweets[i - 1] + 1;
            }
        }

        // Right to left pass
        for (int i = n - 2; i >= 0; i--) {
            if (scores[i] > scores[i + 1]) {
                sweets[i] = Math.max(sweets[i], sweets[i + 1] + 1);
            }
        }

        // Calculate total sweets
        int total = 0;
        for (int s : sweets) {
            total += s;
        }

        // Output result
        System.out.println(total);

        sc.close();
    }
}
