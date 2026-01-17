import java.util.*;

public class SakthiDharan01_treasure_trail_adjustment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String first = sc.nextLine();
        List<Integer> arr = new ArrayList<>();
        for (String s : first.replace(",", " ").trim().split("\\s+")) {
            if (!s.isEmpty()) arr.add(Integer.parseInt(s));
        }
        int n;
        if (sc.hasNextInt()) {
            n = sc.nextInt();
        } else {
            n = arr.isEmpty() ? 0 : arr.remove(arr.size() - 1);
        }
        int len = arr.size();
        if (n > 0 && n <= len) {
            arr.remove(len - n);
        }
        if (arr.isEmpty()) {
            System.out.println("[]");
        } else {
            for (int i = 0; i < arr.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(arr.get(i));
            }
        }
        sc.close();
    }
}
