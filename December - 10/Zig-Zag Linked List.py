class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None

    def insert_end(self, data):
        new = Node(data)
        if not self.head:
            self.head = new
            return
        temp = self.head
        while temp.next:
            temp = temp.next
        temp.next = new

    def display(self):
        temp = self.head
        while temp:
            print(temp.data, end=" -> ")
            temp = temp.next
        print("NULL")


def reorder_zigzag(head):
    if not head or not head.next:
        return head

    slow = head
    fast = head
    while fast.next and fast.next.next:
        slow = slow.next
        fast = fast.next.next

    prev = None
    curr = slow.next
    slow.next = None

    while curr:
        nxt = curr.next
        curr.next = prev
        prev = curr
        curr = nxt

    first = head
    second = prev

    while second:
        t1 = first.next
        t2 = second.next
        first.next = second
        second.next = t1
        first = t1
        second = t2

    return head


N = int(input("Enter number of nodes: "))
values = list(map(int, input("Enter node values: ").split()))

ll = LinkedList()
for v in values:
    ll.insert_end(v)

ll.head = reorder_zigzag(ll.head)

print("Zig-Zag Reordered List:")
ll.display()
