# December 29 - Minimum Weight Cycle in an Undirected Weighted Graph

INF = 10**15

# Read number of vertices
V = int(input().strip())

# Read number of edges
E = int(input().strip())

# Initialize distance matrix
dist = [[INF] * V for _ in range(V)]
for i in range(V):
    dist[i][i] = 0

# Track direct edge weights (for cycle detection)
edges = []

for _ in range(E):
    u, v, w = map(int, input().split())
    edges.append((u, v, w))
    dist[u][v] = min(dist[u][v], w)
    dist[v][u] = min(dist[v][u], w)

# Floyd–Warshall + cycle detection
ans = INF

# Standard Floyd–Warshall loop
for k in range(V):

    # Cycle check **before** updating dist matrix
    for u, v, w in edges:
        # A cycle can be formed: u -> ... -> k -> ... -> v -> u
        ans = min(ans, dist[u][k] + dist[k][v] + w)

    # Now update distances using node k
    for i in range(V):
        for j in range(V):
            if dist[i][j] > dist[i][k] + dist[k][j]:
                dist[i][j] = dist[i][k] + dist[k][j]

# Print result
print(ans if ans < INF else -1)
