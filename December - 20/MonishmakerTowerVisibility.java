import java.util.Scanner;
import java.util.Arrays;
public class MonishmakerTowerVisibility {
        public static int[] towerVisibility(int[] towHeight){
            int n = towHeight.length;
            for(int i=0;i<n;i++){
                int j = i+1;
                int temp= towHeight[i];
                while(j<n){
                    if(towHeight[i]<towHeight[j]){
                        towHeight[i] = towHeight[j];
                        break;
                    }
                    j++;
                }
                if(towHeight[i]==temp){
                    towHeight[i] = -1;
                }
            }
            return towHeight;
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] towHeight = new int[n];
            for(int i=0;i<n;i++){
                towHeight[i] = sc.nextInt();
            } 
            System.out.println(Arrays.toString(towerVisibility(towHeight)));
        }
}
