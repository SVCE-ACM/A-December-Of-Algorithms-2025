n = int(input())
l = int(input())
adj = [[] for _ in range(n)]
for _ in range(l):
    u, v, t = map(int, input().split())
    adj[u].append((v, t))
S = int(input())
INF = 10**18
dist = [INF] * n
dist[S] = 0
pq = [(0, S)]  
while pq:
    best = 0
    for i in range(1, len(pq)):
        if pq[i][0] < pq[best][0]:
            best = i
    d, node = pq.pop(best)
    if d != dist[node]:
        continue
    for nei, w in adj[node]:
        if dist[node] + w < dist[nei]:
            dist[nei] = dist[node] + w
            pq.append((dist[nei], nei))
ans = max(dist)
if ans >= INF:
    print(-1)
else:
    print(ans)