import java.util.*;

public class MountainPeaksInATrail {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        
        for(int x=0; x<n; x++) h[x] = sc.nextInt();
        
        ArrayList<Integer> peakList = new ArrayList<>();
        
        for(int x=1; x<n-1; x++){
            if(h[x] > h[x-1] && h[x] > h[x+1]){
                peakList.add(x);
            }
        }
        
        if(peakList.size() == 0){
            System.out.println(-1);
        }
        else{
            String output = "";
            for(int x=0; x<peakList.size(); x++){
                output += peakList.get(x);
                if(x < peakList.size()-1) output += " ";
            }
            System.out.println(output);
        }
        sc.close();
    }
}
