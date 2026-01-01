import java.util.Scanner;
import java.util.ArrayList;

public class import java.util.Scanner;
import java.util.ArrayList;

public class Lingesh-coder_perfectSquaresCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        func(arr, n);

        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
        System.out.println(arr.size());
    }

    public static void func(ArrayList<Integer> arr, int n) {
        for (int i = 1; i * i <= n; i++) {
            arr.add(i * i);
        }
    }
} {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        func(arr, n);

        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
        System.out.println(arr.size());
    }

    public static void func(ArrayList<Integer> arr, int n) {
        for (int i = 1; i * i <= n; i++) {
            arr.add(i * i);
        }
    }
}