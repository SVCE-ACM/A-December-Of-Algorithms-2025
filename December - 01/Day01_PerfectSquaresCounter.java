import java.util.Scanner;

public class Day01_PerfectSquaresCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int count = 0;
        StringBuilder output = new StringBuilder();

        int i = 1;
        while (i * i <= N) {
            output.append(i * i).append(" ");
            count++;
            i++;
        }

        if (count > 0) {
            System.out.println(output.toString().trim());
        }
        System.out.println(count);

        scanner.close();
    }
}
