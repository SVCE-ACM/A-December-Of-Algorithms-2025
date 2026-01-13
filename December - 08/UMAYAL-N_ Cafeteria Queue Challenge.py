students = list(map(int, input().strip("[]").split(",")))
sandwiches = list(map(int, input().strip("[]").split(",")))

from collections import deque

queue = deque(students)
i = 0
attempts = 0

while queue and attempts < len(queue):
    if queue[0] == sandwiches[i]:
        queue.popleft()
        i += 1
        attempts = 0
    else:
        queue.append(queue.popleft())
        attempts += 1

print(len(queue))

