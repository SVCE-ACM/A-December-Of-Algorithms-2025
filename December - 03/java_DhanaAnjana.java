/*Dhana Anjana
December 03 2025
Bridge Crossing Challenge*/
import java.util.Scanner;
public class java_DhanaAnjana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = input.length;
        int[] stones = new int[n];
        for (int i = 0; i < n; i++) {
            stones[i] = Integer.parseInt(input[i]);
        }

        boolean canReachEnd = canJumpToEnd(stones);
        System.out.println(canReachEnd);

        scanner.close();
    }

    private static boolean canJumpToEnd(int[] stones) {
        int maxReach = 0;
        for (int i = 0; i < stones.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + stones[i]);
            if (maxReach >= stones.length - 1) {
                return true;
            }
        }
        return false;
    }
}