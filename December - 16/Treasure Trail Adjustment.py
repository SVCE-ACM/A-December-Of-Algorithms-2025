class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


def remove_nth_from_end(head, n):
    dummy = Node(0)
    dummy.next = head

    fast = dummy
    slow = dummy

    for _ in range(n + 1):
        fast = fast.next

    while fast:
        fast = fast.next
        slow = slow.next

    slow.next = slow.next.next
    return dummy.next


def print_list(head):
    result = []
    while head:
        result.append(head.data)
        head = head.next
    print(result)

N = int(input("Enter number of nodes: "))
values = list(map(int, input("Enter node values: ").split()))
n = int(input("Enter n (position from end): "))

head = Node(values[0])
current = head
for v in values[1:]:
    current.next = Node(v)
    current = current.next

head = remove_nth_from_end(head, n)

print_list(head)
