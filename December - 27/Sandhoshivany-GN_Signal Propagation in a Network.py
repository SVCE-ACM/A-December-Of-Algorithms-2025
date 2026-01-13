import heapq

def signal_propagation_time(N, M, links, S):
  
    graph = [[] for _ in range(N)]
    for u, v, t in links:
        graph[u].append((v, t))

    dist = [float('inf')] * N
    dist[S] = 0
    pq = [(0, S)] 

    while pq:
        curr_time, u = heapq.heappop(pq)
        if curr_time > dist[u]:
            continue 

        for v, delay in graph[u]:
            if dist[u] + delay < dist[v]:
                dist[v] = dist[u] + delay
                heapq.heappush(pq, (dist[v], v))

    max_time = max(dist)
    return -1 if max_time == float('inf') else max_time



N = int(input())
M = int(input())
links = [tuple(map(int, input().split())) for _ in range(M)]
S = int(input())

print(signal_propagation_time(N, M, links, S))
