import java.util.*;

public class dhanusiyasri_Bridge_Crossing_Challenge {
    public static void cancrossBridge(ArrayList<Integer> stones){
        String result="true";
        int n = stones.size();
        for(int i=0;i<n;i++){
            if(stones.get(i)==0){
                result="false";
                break;
            }
        }
        System.out.println(result);
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        ArrayList<Integer> stones = new ArrayList<>();
        for (String s : line.split(",")) {
            stones.add(Integer.parseInt(s));
        }
        cancrossBridge(stones);
        sc.close();
    }
}
//Note:
//Input: A single line containing comma-separated integers representing the stones.
//Output: "true" if the bridge can be crossed, "false" otherwise.
//Example Input format: 2,3,1,1,4