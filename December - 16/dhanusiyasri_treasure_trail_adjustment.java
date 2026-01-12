import java.util.Scanner;
import java.util.LinkedList;

public class dhanusiyasri_treasure_trail_adjustment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> head = new LinkedList<>();
        String line = sc.nextLine();
        line = line.replaceAll("[\\[\\]]", ""); 
        String[] parts = line.trim().split("[\\s,]+");

        // Add all numbers to list
        for (String p : parts) {
            head.add(Integer.parseInt(p));
        }
        int pos=head.removeLast();
        head.remove(head.size()-pos);
        for(int i:head) {
            System.out.print(i+" ");
        }
        sc.close();
    }
}
/*
Input Format:
A list of integers in the format [a1, a2, a3, ..., an] followed by an integer k on the next line.
The last integer in the list represents the position from the end of the list to be removed.
Input: [1, 2, 3, 4, 5] 2
Output: 1 2 3 5

Input: [10, 20, 30, 40, 50, 60] 4
Output: 10 20 30 50 60
 */