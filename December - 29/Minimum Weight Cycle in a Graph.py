V = int(input())
E = int(input())
edges = [list(map(int, input().split())) for _ in range(E)]

INF = 10**9
dist = [[INF]*V for _ in range(V)]
for i in range(V):
    dist[i][i] = 0

# Fill adjacency
for u, v, w in edges:
    dist[u][v] = w
    dist[v][u] = w  # undirected

min_cycle = INF

# Floyd-Warshall style
for k in range(V):
    # Check for cycles involving k
    for i in range(k):
        for j in range(i+1, k):
            if dist[i][j] != INF and dist[i][k] != INF and dist[k][j] != INF:
                min_cycle = min(min_cycle, dist[i][j] + dist[i][k] + dist[k][j])
    # Update shortest paths
    for i in range(V):
        for j in range(V):
            if dist[i][k] + dist[k][j] < dist[i][j]:
                dist[i][j] = dist[i][k] + dist[k][j]

print(min_cycle)
