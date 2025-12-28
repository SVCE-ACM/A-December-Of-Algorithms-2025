import heapq
V = int(input())
E = int(input())
edges = []
for _ in range(E):
    edges.append(list(map(int, input().split())))
INF = 10**18
ans = INF
for i in range(E):
    u, v, w = edges[i]
    graph = [[] for _ in range(V)]
    for j in range(E):
        if i != j:
            a, b, wt = edges[j]
            graph[a].append((b, wt))
            graph[b].append((a, wt))
    dist = [INF] * V
    dist[u] = 0
    pq = [(0, u)]
    while pq:
        d, node = heapq.heappop(pq)
        for nei, wt in graph[node]:
            if dist[nei] > d + wt:
                dist[nei] = d + wt
                heapq.heappush(pq, (dist[nei], nei))
    if dist[v] != INF:
        ans = min(ans, dist[v] + w)
print(ans)