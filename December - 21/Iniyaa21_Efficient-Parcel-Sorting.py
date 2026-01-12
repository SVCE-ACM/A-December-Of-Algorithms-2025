from collections import deque

n = int(input())
weights = [int(i) for i in input().split()]

queue = deque(weights)
sorted_weights = sorted(weights)
sorted_output = []

for target in sorted_weights:
    while queue[0] != target:
        parcel = queue.popleft()
        queue.append(parcel)
    sorted_output.append(queue.popleft())

print(*(sorted_output))
