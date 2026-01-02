import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class java_DhanaAnjana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        Queue<Integer> students = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            students.add(scanner.nextInt());
        }
        
        Queue<Integer> sandwiches = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            sandwiches.add(scanner.nextInt());
        }
        
        int noChange = 0;
        
        while (!students.isEmpty() && noChange < students.size()) {
            int student = students.poll();
            int sandwich = sandwiches.peek();
            
            if (student == sandwich) {
                sandwiches.poll();
                noChange = 0;
            } else {
                students.add(student);
                noChange++;
            }
        }
        
        System.out.println(students.size());
        scanner.close();
    }
}
