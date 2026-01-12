import heapq

# input
N = int(input("Enter number of towers: "))
M = int(input("Enter number of links: "))

graph = [[] for _ in range(N)]
for _ in range(M):
    u, v, t = map(int, input().split())
    graph[u].append((v, t))

S = int(input("Enter source tower: "))

# Dijkstra
dist = [float('inf')] * N
dist[S] = 0
heap = [(0, S)]  # (time, node)

while heap:
    time, node = heapq.heappop(heap)
    if time > dist[node]:
        continue
    for nei, t in graph[node]:
        if dist[nei] > time + t:
            dist[nei] = time + t
            heapq.heappush(heap, (dist[nei], nei))

res = max(dist)
if res == float('inf'):
    print(-1)
else:
    print(res)

