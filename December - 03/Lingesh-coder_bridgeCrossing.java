import java.util.*;

public class charusm03_bridgeCrossing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stones = new int[n];
        for (int i = 0; i < n; i++)
            stones[i] = sc.nextInt();
        System.out.println(lastStone(stones));
    }

    public static boolean lastStone(int[] stones) {
        int farthest = 0;
        for (int i = 0; i < stones.length; i++) {
            if (i > farthest)
                return false;
            farthest = Math.max(farthest, i + stones[i]);
        }
        return true;
    }
}