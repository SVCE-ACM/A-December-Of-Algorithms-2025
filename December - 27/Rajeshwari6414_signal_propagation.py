import heapq

N = int(input())
M = int(input())
graph = [[] for _ in range(N)]

for _ in range(M):
    u, v, t = map(int, input().split())
    graph[u].append((v, t))

S = int(input())
dist = [float('inf')] * N
dist[S] = 0
pq = [(0, S)]

while pq:
    d, u = heapq.heappop(pq)
    if d > dist[u]:
        continue
    for v, w in graph[u]:
        if dist[v] > d + w:
            dist[v] = d + w
            heapq.heappush(pq, (dist[v], v))

print(-1 if float('inf') in dist else max(dist))
