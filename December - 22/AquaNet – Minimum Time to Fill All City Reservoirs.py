from collections import deque
V, E = map(int, input().split())
graph = [[] for _ in range(V)]

for _ in range(E):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

initial = list(map(int, input().split()))

queue = deque()
visited = [False] * V
for i in range(V):
    if initial[i] == 1:
        queue.append(i)
        visited[i] = True

minutes = 0

while queue:
    for _ in range(len(queue)):
        node = queue.popleft()
        for neighbor in graph[node]:
            if not visited[neighbor]:
                visited[neighbor] = True
                queue.append(neighbor)
    if queue:
        minutes += 1


if all(visited):
    print(minutes)
else:
    print(-1)
