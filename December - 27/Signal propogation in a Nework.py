import heapq

def min_signal_time(N, M, edges, S):
    # Build adjacency list
    graph = [[] for _ in range(N)]
    for u, v, t in edges:
        graph[u].append((v, t))
    
    # Initialize distances
    dist = [float('inf')] * N
    dist[S] = 0
    
    # Priority queue for Dijkstra (time, node)
    pq = [(0, S)]
    
    while pq:
        time, u = heapq.heappop(pq)
        
        if time > dist[u]:
            continue
        
        for v, t in graph[u]:
            if dist[u] + t < dist[v]:
                dist[v] = dist[u] + t
                heapq.heappush(pq, (dist[v], v))
    
    # If any node is unreachable, return -1
    max_time = max(dist)
    if max_time == float('inf'):
        return -1
    return max_time


# --- Input reading ---
if __name__ == "__main__":
    N = int(input())
    M = int(input())
    edges = []
    for _ in range(M):
        u, v, t = map(int, input().split())
        edges.append((u, v, t))
    S = int(input())
    
    print(min_signal_time(N, M, edges, S))
