from collections import deque
n = int(input())
weights = [int(i) for i in input().split()]
q = deque(weights)
ans=[]
while q:
    mn = min(q)
    while q[0] != mn:
        q.append(q.popleft())
    ans.append(q.popleft())
print(*ans)