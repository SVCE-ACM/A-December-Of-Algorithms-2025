def minimum_weight_cycle(V, edges):
    INF = float('inf')

    dist = [[INF] * V for _ in range(V)]
    graph = [[INF] * V for _ in range(V)]

    for u, v, w in edges:
        dist[u][v] = w
        dist[v][u] = w
        graph[u][v] = w
        graph[v][u] = w

    min_cycle = INF

    for k in range(V):
        
        for i in range(k):
            for j in range(i):
                if dist[i][j] != INF and graph[i][k] != INF and graph[k][j] != INF:
                    cycle_weight = dist[i][j] + graph[i][k] + graph[k][j]
                    min_cycle = min(min_cycle, cycle_weight)

        for i in range(V):
            for j in range(V):
                if dist[i][k] + dist[k][j] < dist[i][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]

    return -1 if min_cycle == INF else min_cycle


V = int(input())
E = int(input())
edges = [list(map(int, input().split())) for _ in range(E)]

print(minimum_weight_cycle(V, edges))
