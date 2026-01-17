class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def reorderList(head):
    if not head or not head.next:
        return head
    
    slow, fast = head, head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next

    prev, curr = None, slow.next
    slow.next = None  
    while curr:
        nxt = curr.next
        curr.next = prev
        prev = curr
        curr = nxt
    
    first, second = head, prev
    while second:
        tmp1, tmp2 = first.next, second.next
        first.next = second
        second.next = tmp1
        first, second = tmp1, tmp2
    
    return head

def build_linked_list(arr):
    dummy = ListNode(0)
    curr = dummy
    for val in arr:
        curr.next = ListNode(val)
        curr = curr.next
    return dummy.next

def print_linked_list(head):
    res = []
    while head:
        res.append(str(head.val))
        head = head.next
    print(" ".join(res))

N = int(input())
arr = list(map(int, input().split()))
head = build_linked_list(arr)
head = reorderList(head)
print_linked_list(head)
