import heapq

INF = 10**9

V = int(input("Enter the number of vertices: "))
E = int(input("Enter the number of edges: "))

edges = []
adj = [[] for _ in range(V)]

for _ in range(E):
    u, v, w = map(int, input().split())
    edges.append((u, v, w))
    adj[u].append((v, w))
    adj[v].append((u, w))

def dijkstra(src, blocked_u, blocked_v):
    dist = [INF] * V
    dist[src] = 0
    pq = [(0, src)]

    while pq:
        d, node = heapq.heappop(pq)
        if d > dist[node]:
            continue

        for nei, w in adj[node]:
            if (node == blocked_u and nei == blocked_v) or \
               (node == blocked_v and nei == blocked_u):
                continue

            if dist[nei] > d + w:
                dist[nei] = d + w
                heapq.heappush(pq, (dist[nei], nei))

    return dist

min_cycle = INF

for u, v, w in edges:
    dist = dijkstra(u, u, v)
    if dist[v] != INF:
        min_cycle = min(min_cycle, dist[v] + w)

print(-1 if min_cycle == INF else min_cycle)
