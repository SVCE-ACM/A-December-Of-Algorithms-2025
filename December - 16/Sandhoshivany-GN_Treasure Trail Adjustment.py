class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def buildList(values):
    if not values:
        return None
    head = ListNode(values[0])
    current = head
    for v in values[1:]:
        current.next = ListNode(v)
        current = current.next
    return head

def listToArray(head):
    result = []
    while head:
        result.append(head.val)
        head = head.next
    return result

def removeNthFromEnd(head, n):
    dummy = ListNode(0, head)
    slow = fast = dummy
    for _ in range(n):
        fast = fast.next
    while fast and fast.next:
        slow = slow.next
        fast = fast.next
    slow.next = slow.next.next
    return dummy.next

if __name__ == "__main__":
    arr_str = input().strip()
    n = int(input().strip())
    arr_str = arr_str.replace("null", "None")
    arr = eval(arr_str)
    head = buildList(arr)
    new_head = removeNthFromEnd(head, n)
    print(listToArray(new_head))
