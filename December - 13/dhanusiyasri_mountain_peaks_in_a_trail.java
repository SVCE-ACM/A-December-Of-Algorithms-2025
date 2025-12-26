import java.util.Scanner;
public class dhanusiyasri_mountain_peaks_in_a_trail {
    public static void mountainpeaks(int[] heights,int n){
        int count =0;
        for(int i=1;i<n-1;i++){
            if(heights[i]>heights[i-1] && heights[i]>heights[i+1]){
                System.out.print(i+" ");
                count++;
            }
        }
        if(count==0){
            System.out.print(-1);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }
        mountainpeaks(heights, n);
        scanner.close();
    }
}