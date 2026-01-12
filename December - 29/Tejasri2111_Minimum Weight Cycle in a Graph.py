# input
V = int(input("Enter number of vertices: "))
E = int(input("Enter number of edges: "))

edges = []
for _ in range(E):
    u, v, w = map(int, input("Enter edge u v w: ").split())
    edges.append((u, v, w))

# initialize distance matrix
INF = float('inf')
dist = [[INF]*V for _ in range(V)]
for i in range(V):
    dist[i][i] = 0

for u, v, w in edges:
    dist[u][v] = min(dist[u][v], w)
    dist[v][u] = min(dist[v][u], w)  # undirected

min_cycle = INF

# Floyd-Warshall + check cycles
for k in range(V):
    for i in range(V):
        for j in range(V):
            if i != j and dist[i][k] != INF and dist[k][j] != INF and dist[i][j] != INF:
                # potential cycle i -> k -> j -> i
                min_cycle = min(min_cycle, dist[i][j] + dist[i][k] + dist[k][j])
    # standard update
    for i in range(V):
        for j in range(V):
            if dist[i][k] + dist[k][j] < dist[i][j]:
                dist[i][j] = dist[i][k] + dist[k][j]

if min_cycle == INF:
    print(-1)
else:
    print(min_cycle)
