from collections import deque

n = int(input())
queue = deque(map(int, input().split()))
sorted_output = []

while queue:
    min_val = min(queue)
    while queue[0] != min_val:
        queue.append(queue.popleft())  # rotate
    sorted_output.append(queue.popleft())  # pick

print(*sorted_output)
