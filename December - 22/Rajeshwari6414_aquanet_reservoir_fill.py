from collections import deque

V, E = map(int, input().split())
graph = [[] for _ in range(V)]

for _ in range(E):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

state = list(map(int, input().split()))
queue = deque()
dist = [-1] * V

for i in range(V):
    if state[i] == 1:
        queue.append(i)
        dist[i] = 0

while queue:
    u = queue.popleft()
    for v in graph[u]:
        if dist[v] == -1:
            dist[v] = dist[u] + 1
            queue.append(v)

if -1 in dist:
    print(-1)
else:
    print(max(dist))
