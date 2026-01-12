class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reorderList(self, head):
        d = []
        t = head
        while t:
            d.append(t.val)
            t = t.next
        if len(d) % 2:
            k = d[:len(d)//2 + 1]
            kk = d[len(d)//2 + 1:][::-1]
        else:
            k = d[:len(d)//2]
            kk = d[len(d)//2:][::-1]
        dummy = ListNode(-1)
        p = dummy
        for i in range(max(len(k), len(kk))):
            if i < len(k):
                p.next = ListNode(k[i])
                p = p.next
            if i < len(kk):
                p.next = ListNode(kk[i])
                p = p.next
        p = dummy.next
        while head and p:
            head.val = p.val
            head = head.next
            p = p.next
n = int(input("Enter N: "))
values = list(map(int, input("Enter node values: ").split()))
head = ListNode(values[0])
curr = head
for i in range(1, n):
    curr.next = ListNode(values[i])
    curr = curr.next
Solution().reorderList(head)
curr = head
while curr:
    print(curr.val, end=" ")
    curr = curr.next