class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def solve():
    n = int(input("Enter N: ").strip())
    values = [int(i) for i in input("Enter node values: ").split()]
    head = ListNode(values[0])
    curr = head
    for i in range(1, n):
        curr.next = ListNode(values[i])
        curr = curr.next

    if n > 2:
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        prev, curr = None, slow.next
        slow.next = None 
        while curr:
            next_node = curr.next
            curr.next = prev
            prev = curr
            curr = next_node
        
        first, second = head, prev
        while second:
            tmp1, tmp2 = first.next, second.next
            first.next = second
            second.next = tmp1
            first, second = tmp1, tmp2

    res = []
    curr = head
    while curr:
        res.append(str(curr.val))
        curr = curr.next
    print(" ".join(res))

solve()