import java.util.Scanner;

public class java_DhanaAnjana {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine().replace("[", "").replace("]", "");
        String[] values = input.split(",");
        
        ListNode head = null, tail = null;
        for (String val : values) {
            val = val.trim();
            if (!val.isEmpty()) {
                ListNode newNode = new ListNode(Integer.parseInt(val));
                if (head == null) {
                    head = newNode;
                    tail = head;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
            }
        }
        
        int n = scanner.nextInt();
        
        head = removeNthFromEnd(head, n);
        
        StringBuilder result = new StringBuilder("[");
        ListNode current = head;
        while (current != null) {
            result.append(current.val);
            current = current.next;
            if (current != null) result.append(",");
        }
        result.append("]");
        
        System.out.println(result.toString());
        scanner.close();
    }
    
    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode first = dummy;
        ListNode second = dummy;
        
        for (int i = 0; i <= n; i++) {
            if (first == null) return head;
            first = first.next;
        }
        
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        second.next = second.next.next;
        
        return dummy.next;
    }
}
