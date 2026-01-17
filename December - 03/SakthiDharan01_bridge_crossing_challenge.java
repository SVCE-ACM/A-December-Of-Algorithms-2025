import java.util.*;
import java.util.regex.*;

public class SakthiDharan01_bridge_crossing_challenge {
    private static List<Integer> parse(String input) {
        Matcher m = Pattern.compile("-?\\d+").matcher(input);
        List<Integer> nums = new ArrayList<>();
        while (m.find()) {
            nums.add(Integer.parseInt(m.group()));
        }
        if (nums.size() > 1 && nums.get(0) == nums.size() - 1) {
            return nums.subList(1, nums.size());
        }
        return nums;
    }

    private static boolean canReach(List<Integer> arr) {
        int far = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (i > far) return false;
            far = Math.max(far, i + arr.get(i));
            if (far >= arr.size() - 1) return true;
        }
        return far >= arr.size() - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) sb.append(sc.nextLine()).append(' ');
        List<Integer> arr = parse(sb.toString());
        if (arr.isEmpty()) return;
        System.out.println(Boolean.toString(canReach(arr)).toLowerCase());
        sc.close();
    }
}
