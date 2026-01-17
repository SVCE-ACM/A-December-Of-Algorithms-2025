class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def removeNthFromEnd(head, n):
    dummy = ListNode(0, head)
    first = dummy
    second = dummy
    for _ in range(n+1):
        first = first.next
    while first:
        first = first.next
        second = second.next
    second.next = second.next.next
    
    return dummy.next

def build_linked_list(arr):
    dummy = ListNode(0)
    curr = dummy
    for val in arr:
        curr.next = ListNode(val)
        curr = curr.next
    return dummy.next
def linked_list_to_list(head):
    res = []
    while head:
        res.append(head.val)
        head = head.next
    return res
if __name__ == "__main__":
    arr = list(map(int, input("head = ").split()))
    n = int(input("n = "))
    head = build_linked_list(arr)
    new_head = removeNthFromEnd(head, n)
    print(linked_list_to_list(new_head))
