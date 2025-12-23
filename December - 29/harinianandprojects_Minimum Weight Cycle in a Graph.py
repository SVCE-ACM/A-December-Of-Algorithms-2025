import heapq

V = int(input())
import sys
edges = []
for line in sys.stdin:
    line = line.strip()
    if not line:
        continue
    u, v, w = map(int, line.split())
    edges.append([u, v, w])

adj = [[] for _ in range(V)]
for u, v, w in edges:
    adj[u].append((v, w))
    adj[v].append((u, w))

INF = float('inf')
min_cycle = INF

def dijkstra(start, forbidden_edge):
    dist = [INF]*V
    dist[start] = 0
    pq = [(0, start)]
    while pq:
        d, u = heapq.heappop(pq)
        if d > dist[u]:
            continue
        for v, w in adj[u]:
            if (u, v) == forbidden_edge or (v, u) == forbidden_edge:
                continue
            if dist[u] + w < dist[v]:
                dist[v] = dist[u] + w
                heapq.heappush(pq, (dist[v], v))
    return dist

for u, v, w in edges:
    dist = dijkstra(u, (u, v))
    if dist[v] != INF:
        min_cycle = min(min_cycle, dist[v] + w)

print(min_cycle if min_cycle != INF else -1)
