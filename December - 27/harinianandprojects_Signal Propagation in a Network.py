import heapq

n = int(input())
m = int(input())

g = [[] for _ in range(n)]
for _ in range(m):
    u, v, t = map(int, input().split())
    g[u].append((v, t))

s = int(input())

inf = 10**18
dist = [inf]*n
dist[s] = 0

pq = [(0, s)]

while pq:
    d, u = heapq.heappop(pq)
    if d > dist[u]:
        continue
    for v, w in g[u]:
        if dist[v] > d + w:
            dist[v] = d + w
            heapq.heappush(pq, (dist[v], v))

ans = max(dist)
print(ans if ans < inf else -1)
