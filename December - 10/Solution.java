class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
   
    public static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverseLinkedList(slow);
        ListNode ptr1 = head;
        ListNode ptr2 = slow;
        ListNode prev = null;
        while (ptr1 != null && ptr2 != null) {
            ListNode temp1 = ptr1.next;//2
            ListNode temp2 = ptr2.next;//5
            ptr1.next = ptr2;
            ptr2.next = temp1;
            prev = ptr2;
            ptr1 = temp1;
            ptr2 = temp2;
        }
        if (prev != null) {
            prev.next = null;
        }
    }
}