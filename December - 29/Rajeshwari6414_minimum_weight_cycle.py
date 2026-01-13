INF = 10**15
V = int(input())
edges = eval(input())

dist = [[INF]*V for _ in range(V)]
for i in range(V):
    dist[i][i] = 0

for u, v, w in edges:
    dist[u][v] = dist[v][u] = min(dist[u][v], w)

ans = INF
for k in range(V):
    for i in range(V):
        for j in range(V):
            if i != j and i != k and j != k:
                ans = min(ans, dist[i][j] + dist[i][k] + dist[k][j])
    for i in range(V):
        for j in range(V):
            dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

print(ans if ans < INF else -1)
