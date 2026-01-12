class Node:
    def __init__(self, val):
        self.val = val
        self.next = None

def reorderList(head):
    if not head or not head.next:
        return head

  
    slow, fast = head, head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next

    prev = None
    curr = slow
    while curr:
        nxt = curr.next
        curr.next = prev
        prev = curr
        curr = nxt

    # Step 3: Merge two halves
    first, second = head, prev
    while second.next:
        t1 = first.next
        t2 = second.next

        first.next = second
        second.next = t1

        first = t1
        second = t2

    return head


N = int(input())
values = list(map(int, input().split()))
head = Node(values[0])
curr = head
for v in values[1:]:
    curr.next = Node(v)
    curr = curr.next


head = reorderList(head)
curr = head
result = []
while curr:
    result.append(str(curr.val))
    curr = curr.next

print(" ".join(result))
