import java.util.Arrays;
import java.util.Scanner;

public class dhanusiyasri_the_missing_positive_element {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        for(int i=1;i<=n;i++){
            boolean found=false;
            for(int j:arr){
                if(i==j){
                    found=true;
                    break;
                }
            }
            if(!found){
                System.out.println("Missing Number: "+i);
                break;
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]!=i+1){
                System.out.println("Duplicate Number: "+arr[i]);
                break;
            }
        }
        sc.close();
    }
    
}
