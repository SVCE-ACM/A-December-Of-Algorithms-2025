import heapq

def dijkstra(V, graph, src, dest):
    dist = [float('inf')] * V
    dist[src] = 0
    pq = [(0, src)]
    while pq:
        d, node = heapq.heappop(pq)
        if d > dist[node]:
            continue
        for nei, wt in graph[node]:
            if dist[nei] > d + wt:
                dist[nei] = d + wt
                heapq.heappush(pq, (dist[nei], nei))
    return dist[dest]

def minimum_cycle(V, edges):
    graph = [[] for _ in range(V)]
    for u, v, w in edges:
        graph[u].append((v, w))
        graph[v].append((u, w))
    min_cycle = float('inf')
    for u, v, w in edges:
        graph[u].remove((v, w))
        graph[v].remove((u, w))
        shortest = dijkstra(V, graph, u, v)
        if shortest != float('inf'):
            min_cycle = min(min_cycle, shortest + w)
        graph[u].append((v, w))
        graph[v].append((u, w))
    return min_cycle if min_cycle != float('inf') else -1
if __name__ == "__main__":
    V = int(input().strip())
    E = int(input().strip())
    edges = [list(map(int, input().split())) for _ in range(E)]
    result = minimum_cycle(V, edges)
    print(result)
