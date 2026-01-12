import java.util.Scanner;

public class java_DhanaAnjana {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        ListNode head = null;
        ListNode tail = null;
        
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            if (head == null) {
                head = new ListNode(val);
                tail = head;
            } else {
                tail.next = new ListNode(val);
                tail = tail.next;
            }
        }
        
        head = reorderList(head);
        
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(" ");
            current = current.next;
        }
        System.out.println();
        
        scanner.close();
    }
    
    static ListNode reorderList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode mid = slow;
        ListNode second = reverseList(mid);
        
        ListNode first = head;
        while (second.next != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            
            first.next = second;
            second.next = temp1;
            
            first = temp1;
            second = temp2;
        }
        
        return head;
    }
    
    static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
