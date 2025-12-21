class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast n steps ahead
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }

        // Move both until fast reaches end
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        // Delete node
        slow.next = slow.next.next;

        return dummy.next;
    }
}
