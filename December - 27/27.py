import heapq

def min_signal_time(N, edges, S):
    graph = [[] for _ in range(N)]
    for u, v, t in edges:
        graph[u].append((v, t))
    dist = [float('inf')] * N
    dist[S] = 0
    pq = [(0, S)]
    while pq:
        time, node = heapq.heappop(pq)
        if time > dist[node]:
            continue
        for nei, wt in graph[node]:
            if dist[nei] > time + wt:
                dist[nei] = time + wt
                heapq.heappush(pq, (dist[nei], nei))
    max_time = max(dist)
    return -1 if max_time == float('inf') else max_time

if __name__ == "__main__":
    N = int(input().strip())
    M = int(input().strip())
    edges = [tuple(map(int, input().split())) for _ in range(M)]
    S = int(input().strip())
    
    result = min_signal_time(N, edges, S)
    print(result)
