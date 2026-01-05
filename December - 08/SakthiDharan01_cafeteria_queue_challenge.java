import java.util.*;
import java.util.regex.*;

public class SakthiDharan01_cafeteria_queue_challenge {
    private static List<Integer> parse(String line) {
        Matcher m = Pattern.compile("-?\\d+").matcher(line);
        List<Integer> res = new ArrayList<>();
        while (m.find()) res.add(Integer.parseInt(m.group()));
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String l1 = sc.nextLine();
        if (!sc.hasNextLine()) return;
        String l2 = sc.nextLine();
        List<Integer> students = parse(l1);
        List<Integer> sandwiches = parse(l2);
        int count0 = 0, count1 = 0;
        for (int s : students) {
            if (s == 0) count0++; else count1++;
        }
        for (int s : sandwiches) {
            if (s == 0) {
                if (count0 == 0) break;
                count0--;
            } else {
                if (count1 == 0) break;
                count1--;
            }
        }
        System.out.println(count0 + count1);
        sc.close();
    }
}
