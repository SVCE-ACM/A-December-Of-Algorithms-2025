import heapq

INF = 10**18

# -------- INPUT --------
V = int(input("Enter number of vertices (V): "))
E = int(input("Enter number of edges (E): "))

adj = [[] for _ in range(V)]
edges = []

print("Enter edges (u v w):")
for _ in range(E):
    u, v, w = map(int, input().split())
    adj[u].append((v, w))
    adj[v].append((u, w))
    edges.append((u, v, w))

# -------- DIJKSTRA FUNCTION --------
def dijkstra(start, block_u, block_v):
    dist = [INF] * V
    dist[start] = 0
    pq = [(0, start)]

    while pq:
        curr_dist, u = heapq.heappop(pq)

        if curr_dist > dist[u]:
            continue

        for v, w in adj[u]:
            # Skip the blocked edge
            if (u == block_u and v == block_v) or (u == block_v and v == block_u):
                continue

            new_dist = curr_dist + w
            if new_dist < dist[v]:
                dist[v] = new_dist
                heapq.heappush(pq, (new_dist, v))

    return dist

# -------- FIND MINIMUM CYCLE --------
answer = INF

for u, v, w in edges:
    dist = dijkstra(u, u, v)
    if dist[v] != INF:
        answer = min(answer, dist[v] + w)

# -------- OUTPUT --------
if answer == INF:
    print("Minimum weight cycle: -1")
else:
    print("Minimum weight cycle:", answer)
