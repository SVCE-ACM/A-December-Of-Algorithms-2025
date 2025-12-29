import java.util.*;

public class Magesh2424_TreasureTrailAdjustment {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Remove nth node from end
    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the node
        slow.next = slow.next.next;

        return dummy.next;
    }

    // Print linked list
    static void printList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }

        ListNode curr = head;
        System.out.print("[");
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(",");
            curr = curr.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of nodes
        int sz = sc.nextInt();

        // Read node values
        ListNode head = null, tail = null;
        for (int i = 0; i < sz; i++) {
            int val = sc.nextInt();
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Read n
        int n = sc.nextInt();

        // Remove nth node from end
        head = removeNthFromEnd(head, n);

        // Print updated list
        printList(head);

        sc.close();
    }
}

