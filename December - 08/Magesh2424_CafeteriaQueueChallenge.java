import java.util.*;

public class Magesh2424_CafeteriaQueueChallenge {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of students / sandwiches
        int n = sc.nextInt();

        int[] students = new int[n];
        int[] sandwiches = new int[n];

        // Read student preferences
        for (int i = 0; i < n; i++) {
            students[i] = sc.nextInt();
        }

        // Read sandwich stack (0 = top)
        for (int i = 0; i < n; i++) {
            sandwiches[i] = sc.nextInt();
        }

        // Count student preferences
        int count0 = 0, count1 = 0;
        for (int s : students) {
            if (s == 0) count0++;
            else count1++;
        }

        // Process sandwiches
        for (int i = 0; i < n; i++) {
            if (sandwiches[i] == 0) {
                if (count0 == 0) break;
                count0--;
            } else {
                if (count1 == 0) break;
                count1--;
            }
        }

        // Remaining students
        System.out.println(count0 + count1);

        sc.close();
    }
}
