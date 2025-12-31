class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def removeNthFromEnd(head, n):
    dummy = ListNode(0)
    dummy.next = head
    first = dummy
    second = dummy

    
    for _ in range(n + 1):
        first = first.next

    
    while first:
        first = first.next
        second = second.next

    
    second.next = second.next.next

    return dummy.next


def build_linked_list(lst):
    dummy = ListNode(0)
    curr = dummy
    for val in lst:
        curr.next = ListNode(val)
        curr = curr.next
    return dummy.next

def print_linked_list(head):
    res = []
    while head:
        res.append(head.val)
        head = head.next
    print(res)


head = build_linked_list([1,2,3,4,5])
n = 2
new_head = removeNthFromEnd(head, n)
print_linked_list(new_head)  


head = build_linked_list([1])
n = 1
new_head = removeNthFromEnd(head, n)
print_linked_list(new_head)  


head = build_linked_list([1,2])
n = 1
new_head = removeNthFromEnd(head, n)
print_linked_list(new_head) 
