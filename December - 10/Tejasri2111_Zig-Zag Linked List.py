# Define Node class
class Node:
    def __init__(self, val):
        self.val = val
        self.next = None

# Function to print linked list
def printList(head):
    curr = head
    while curr:
        print(curr.val, end=" ")
        curr = curr.next
    print()

# Function to reorder list in zig-zag pattern
def reorderList(head):
    if not head or not head.next:
        return head
    
    # Step 1: Find middle of list
    slow = fast = head
    while fast.next and fast.next.next:
        slow = slow.next
        fast = fast.next.next
    
    # Step 2: Reverse second half
    prev = None
    curr = slow.next
    slow.next = None  # split the list
    while curr:
        nxt = curr.next
        curr.next = prev
        prev = curr
        curr = nxt
    
    # Step 3: Merge two halves
    first, second = head, prev
    while second:
        tmp1, tmp2 = first.next, second.next
        first.next = second
        second.next = tmp1
        first, second = tmp1, tmp2
    
    return head

# Input
N = int(input("Enter number of nodes: "))
values = list(map(int, input("Enter node values separated by space: ").split()))

# Create linked list
head = Node(values[0])
curr = head
for val in values[1:]:
    curr.next = Node(val)
    curr = curr.next

# Reorder list
head = reorderList(head)

# Print reordered list
printList(head)
