from collections import deque

N = int(input())
parcels = list(map(int, input().split()))

queue = deque(parcels)
sorted_output = []

while queue:
    min_weight = min(queue)  
    while queue[0] != min_weight:
        queue.append(queue.popleft())
    
    sorted_output.append(queue.popleft())

print(*sorted_output)
