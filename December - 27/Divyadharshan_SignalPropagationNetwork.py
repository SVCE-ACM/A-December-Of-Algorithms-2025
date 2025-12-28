import heapq

N = int(input())
M = int(input())

graph = [[] for _ in range(N)]
for _ in range(M):
    u, v, t = map(int, input().split())
    graph[u].append((v, t))

S = int(input())

pq = [(0, S)]
dist = [float('inf')] * N
dist[S] = 0

while pq:
    time, node = heapq.heappop(pq)
    if time > dist[node]:
        continue
    for nei, wt in graph[node]:
        if dist[nei] > time + wt:
            dist[nei] = time + wt
            heapq.heappush(pq, (dist[nei], nei))

ans = max(dist)
print(ans if ans < float('inf') else -1)
