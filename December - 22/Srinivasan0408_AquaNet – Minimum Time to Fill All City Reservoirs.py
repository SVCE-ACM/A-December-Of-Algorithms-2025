n, e = map(int, input().split())
adj = [[] for _ in range(n)]
for _ in range(e):
    u, v = map(int, input().split())
    adj[u].append(v)
    adj[v].append(u)
filled = list(map(int, input().split()))
dist = [-1] * n
queue = []
front = 0

for i in range(n):
    if filled[i] == 1:
        queue.append(i)
        dist[i] = 0

while front < len(queue):
    node = queue[front]
    front += 1

    for nei in adj[node]:
        if dist[nei] == -1:     
            dist[nei] = dist[node] + 1
            queue.append(nei)
ans = 0
for d in dist:
    if d == -1:
        ans = -1
        break
    ans = max(ans, d)

print(ans)