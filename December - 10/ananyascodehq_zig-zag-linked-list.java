// Zig-Zag Linked List (Reorder List)
// December 10
/*
Problem Description
Reorder the linked list into a zig-zag pattern by modifying pointers only:
L0 → Ln → L1 → Ln-1 → L2 → …
Constraints demand an in-place solution with linear time.

Approach:
Use slow/fast pointers to locate the mid-node.
Reverse the second half in-place.
Merge the two lists by alternating nodes.
Each pointer modification is carefully sequenced to avoid losing references.

Time & Space Complexity:
Time: O(N)
Space: O(1)
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {

    // Main function to reorder list in-place
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1) Find middle of the list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2) Reverse second half
        ListNode second = reverse(slow);
        ListNode first = head;

        // 3) Merge alternating nodes
        while (second.next != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }

    // Helper: Reverse linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        return prev;
    }
}
