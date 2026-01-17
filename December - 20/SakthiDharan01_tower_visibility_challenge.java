import java.util.*;

public class SakthiDharan01_tower_visibility_challenge {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] h = new int[n];
        for (int i=0;i<n && sc.hasNextInt();i++) h[i]=sc.nextInt();
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=n-1;i>=0;i--){
            while (!stack.isEmpty() && h[stack.peek()] <= h[i]) stack.pop();
            res[i] = stack.isEmpty() ? -1 : h[stack.peek()];
            stack.push(i);
        }
        for (int i=0;i<n;i++){
            if (i>0) System.out.print(" ");
            System.out.print(res[i]);
        }
        sc.close();
    }
}
