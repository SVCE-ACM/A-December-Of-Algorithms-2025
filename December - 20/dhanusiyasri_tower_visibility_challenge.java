import java.util.Scanner;

public class dhanusiyasri_tower_visibility_challenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            int nextTaller = -1;
            for (int j = i + 1; j < n; j++) {
                if (heights[j] > heights[i]) {
                nextTaller = heights[j];
                break; // stop at the first taller tower
            }
            }
            System.out.print(nextTaller+" ");
        }
        sc.close();
    }
}