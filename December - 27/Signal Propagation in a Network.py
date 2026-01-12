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

heap = [(0, S)]  # (distance, node)

while heap:
    d, u = heapq.heappop(heap)
    if d > dist[u]:
        continue
    for v, t in graph[u]:
        if dist[v] > d + t:
            dist[v] = d + t
            heapq.heappush(heap, (dist[v], v))

if any(d == float('inf') for d in dist):
    print(-1)
else:
    print(max(dist))
