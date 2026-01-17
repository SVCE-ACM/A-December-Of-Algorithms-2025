package Dec10;
import java.util.*;
public class zigzagLinkedList {
        static class Node {
            int val;
            Node next;
            Node(int val) {
                this.val = val;
                this.next = null;
            }
        }

        static void reorderList(Node head) {
            if (head == null || head.next == null) return;

            ArrayList<Node> list = new ArrayList<>();
            Node curr = head;

            // Store nodes
            while (curr != null) {
                list.add(curr);
                curr = curr.next;
            }

            int i = 0, j = list.size() - 1;

            // Re-link in zig-zag
            while (i < j) {
                list.get(i).next = list.get(j);
                i++;

                if (i == j) break;

                list.get(j).next = list.get(i);
                j--;
            }

            // End the list
            list.get(i).next = null;
        }

        static void printList(Node head) {
            while (head != null) {
                System.out.print(head.val + " ");
                head = head.next;
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node curr = head;

            for (int i = 1; i < n; i++) {
                curr.next = new Node(sc.nextInt());
                curr = curr.next;
            }

            reorderList(head);
            printList(head);
        }
    }


