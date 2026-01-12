class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def remove_nth_from_end(head, n):
    dummy = ListNode(0)
    dummy.next = head
    first = dummy
    second = dummy
    
    for i in range(n + 1):
        first = first.next
    
    while first:
        first = first.next
        second = second.next
    
    second.next = second.next.next
    
    return dummy.next

def build_linked_list(values):
    if not values:
        return None
    head = ListNode(values[0])
    current = head
    for val in values[1:]:
        current.next = ListNode(val)
        current = current.next
    return head

def linked_list_to_list(head):
    result = []
    current = head
    while current:
        result.append(current.val)
        current = current.next
    return result

input_str = input().strip()
parts = input_str.split(", n = ")
head_str = parts[0].replace("head = ", "").strip()
n = int(parts[1])

values_str = head_str.strip("[]").split(",")
values = [int(v.strip()) for v in values_str]

head = build_linked_list(values)
new_head = remove_nth_from_end(head, n)
result = linked_list_to_list(new_head)

print(result)