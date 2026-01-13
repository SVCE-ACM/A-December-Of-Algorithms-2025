class Node:
    def __init__(self, val):
        self.val = val
        self.next = None

def reorderList(head):
    if not head or not head.next:
        return head

    
    slow, fast = head, head
    while fast.next and fast.next.next:
        slow = slow.next
        fast = fast.next.next

    
    prev, curr = None, slow.next
    while curr:
        nxt = curr.next
        curr.next = prev
        prev = curr
        curr = nxt
    slow.next = None  # Split list

    
    first, second = head, prev
    while second:
        tmp1, tmp2 = first.next, second.next
        first.next = second
        second.next = tmp1
        first, second = tmp1, tmp2

    return head


N = int(input("Enter N: "))
values = list(map(int, input("Enter node values: ").split()))


head = Node(values[0])
curr = head
for v in values[1:]:
    curr.next = Node(v)
    curr = curr.next


head = reorderList(head)


curr = head
while curr:
    print(curr.val, end=" ")
    curr = curr.next
