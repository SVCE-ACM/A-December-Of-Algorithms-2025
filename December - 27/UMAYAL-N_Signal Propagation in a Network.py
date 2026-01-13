# December 27 - Network Delay Time (Dijkstra)

import heapq

N = int(input().strip())
M = int(input().strip())

adj = [[] for _ in range(N)]
for _ in range(M):
    u, v, t = map(int, input().split())
    adj[u].append((v, t))

S = int(input().strip())

dist = [10**18] * N
dist[S] = 0

pq = [(0, S)]

while pq:
    d, node = heapq.heappop(pq)
    if d > dist[node]: 
        continue

    for nei, w in adj[node]:
        if dist[nei] > d + w:
            dist[nei] = d + w
            heapq.heappush(pq, (dist[nei], nei))

ans = max(dist)
print(ans if ans < 10**18 else -1)
