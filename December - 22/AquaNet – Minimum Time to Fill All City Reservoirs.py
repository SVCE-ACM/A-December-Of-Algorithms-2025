from collections import deque

V, E = map(int, input().split())

adj = [[] for _ in range(V)]

for _ in range(E):
    u, v = map(int, input().split())
    adj[u].append(v)
    adj[v].append(u)

state = list(map(int, input().split()))

queue = deque()
time = [-1] * V

for i in range(V):
    if state[i] == 1:
        queue.append(i)
        time[i] = 0

while queue:
    node = queue.popleft()
    for nei in adj[node]:
        if time[nei] == -1:
            time[nei] = time[node] + 1
            queue.append(nei)

ans = 0
for t in time:
    if t == -1:
        print(-1)
        exit()
    ans = max(ans, t)

print(ans)
