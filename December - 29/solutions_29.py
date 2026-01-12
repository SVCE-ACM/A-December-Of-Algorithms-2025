def find_min_cycle(V, edges):
    graph = [[] for _ in range(V)]
    
    for u, v, w in edges:
        graph[u].append((v, w))
        graph[v].append((u, w))
    
    min_cycle = float('inf')
    
    for edge in edges:
        u, v, w = edge
        
        for i in range(V):
            for j in range(V):
                if i == j:
                    continue
                
        dist = [[float('inf')] * V for _ in range(V)]
        
        for i in range(V):
            dist[i][i] = 0
        
        for a, b, wt in edges:
            if (a == u and b == v) or (a == v and b == u):
                continue
            dist[a][b] = min(dist[a][b], wt)
            dist[b][a] = min(dist[b][a], wt)
        
        for k in range(V):
            for i in range(V):
                for j in range(V):
                    if dist[i][k] + dist[k][j] < dist[i][j]:
                        dist[i][j] = dist[i][k] + dist[k][j]
        
        if dist[u][v] != float('inf'):
            cycle_weight = dist[u][v] + w
            min_cycle = min(min_cycle, cycle_weight)
    
    return min_cycle if min_cycle != float('inf') else -1

V = int(input("Enter number of vertices: "))
E = int(input("Enter number of edges: "))
edges = []

print("Enter edges (u v w):")
for _ in range(E):
    u, v, w = map(int, input().split())
    edges.append([u, v, w])

result = find_min_cycle(V, edges)
print(result)
