# Efficient Parcel Sorting
from collections import deque

N = int(input().strip())
q = deque(map(int, input().split()))
sorted_list = []

while q:
    mn = min(q)
    while q[0] != mn:
        q.append(q.popleft())
    sorted_list.append(q.popleft())

print(*sorted_list)
