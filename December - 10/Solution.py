# Enter your code here
class Node:
    def __init__(self,data):
        self.data = data
        self.next=None
class Solution:
    def Find_solution(self,head):
        if not head or not head:
            return head
            
        slow = head
        fast = head.next
        
        while fast and fast.next:
            
            fast = fast.next.next
            slow = slow.next
        
        current = slow.next
        slow.next=None
        
        prev = None
        
        #reversed
        
        while current:
            nxt = current.next
            current.next = prev
            prev = current
            current = nxt
            
        first = head
        second = prev
        
        while second:
            t1=first.next
            t2=second.next
            
            first.next=second
            second.next=t1
            
            first = t1
            second = t2
            
        return head
        
    def printList(self,head):
        if not head or not head.next:
            return head
        current = self.Find_solution(head)
        while current:
            print(current.data,end=" ")
            current = current.next
            
n = int(input("Enter N: "))

l=list(map(int,input("Enter node values: ").split()))
head = None
tail = None

for i in l:
    node = Node(i)
    if not head:
        head = tail = node
    else:
        tail.next=node
        tail=node
f2=Solution()
f2.printList(head)