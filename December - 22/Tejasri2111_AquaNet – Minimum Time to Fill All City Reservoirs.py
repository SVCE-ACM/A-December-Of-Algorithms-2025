from collections import deque

V, E = map(int, input().split())

# build graph
graph = [[] for _ in range(V)]
for _ in range(E):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

water = list(map(int, input().split()))

q = deque()
visited = [False] * V

# add initially filled reservoirs to queue
for i in range(V):
    if water[i] == 1:
        q.append((i, 0))  # (node, minute)
        visited[i] = True

minutes = 0

while q:
    node, minute = q.popleft()
    minutes = max(minutes, minute)
    
    for nei in graph[node]:
        if not visited[nei]:
            visited[nei] = True
            q.append((nei, minute + 1))

# check if any reservoir is unfilled
if all(visited):
    print(minutes)
else:
    print(-1)
