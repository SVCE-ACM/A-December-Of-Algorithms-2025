from collections import deque

N = int(input())
weights = list(map(int, input().split()))

q = deque(weights)
sorted_out = []

while q:
    # find the minimum weight in the current queue
    min_w = min(q)
    
    # rotate until the min is at the front
    while q[0] != min_w:
        q.append(q.popleft())
    
    # pick and place
    sorted_out.append(q.popleft())

print(*sorted_out)
