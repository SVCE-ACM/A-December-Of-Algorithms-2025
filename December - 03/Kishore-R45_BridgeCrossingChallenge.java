import java.util.Scanner;

public class BridgeCrossingChallenge {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] jump = new int[size];
        
        for(int x=0; x<size; x++){
            jump[x] = sc.nextInt();
        }
        
        int farthest = 0;
        int idx = 0;
        
        while(idx < size){
            if(idx > farthest){
                System.out.println("false");
                return;
            }
            
            int temp = idx + jump[idx];
            if(temp > farthest) farthest = temp;
            
            if(farthest >= size-1){
                System.out.println("true");
                return;
            }
            idx++;
        }
        
        System.out.println(farthest >= size-1 ? "true" : "false");
        sc.close();
    }
}
