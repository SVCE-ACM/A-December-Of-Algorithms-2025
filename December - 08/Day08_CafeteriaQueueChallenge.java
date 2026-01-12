import java.util.*;

public class Day08_CafeteriaQueueChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine().trim();
        String s2 = sc.nextLine().trim();
        s1 = s1.replaceAll("[\[\] ]", "");
        s2 = s2.replaceAll("[\[\] ]", "");
        int[] students = Arrays.stream(s1.split(",")).filter(x->!x.isEmpty()).mapToInt(Integer::parseInt).toArray();
        int[] sandwiches = Arrays.stream(s2.split(",")).filter(x->!x.isEmpty()).mapToInt(Integer::parseInt).toArray();
        int[] count = new int[2];
        for (int v:students) count[v]++;
        int i=0;
        for (int s: sandwiches) {
            if (count[s]==0) break;
            count[s]--;
            i++;
        }
        System.out.println(students.length - i);
        sc.close();
    }
}
