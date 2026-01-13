import java.util.*;

public class charusm03_sumOfUniqueElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(sumOfUnique(arr));
    }

    public static int sumOfUnique(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x : arr)
            map.put(x, map.getOrDefault(x, 0) + 1);

        int sum = 0;
        for (int x : map.keySet()) {
            if (map.get(x) == 1)
                sum += x;
        }

        return sum;
    }
}
