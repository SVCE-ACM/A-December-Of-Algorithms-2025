import heapq

def func():
    n = int(input()) 
    m = int(input())
    adj = [[] for _ in range(n)]
    for _ in range(m):
        u, v, t = [int(i) for i in input().split()]
        adj[u].append((v, t))
        
    source = int(input())

    pq = [(0, source)]
    distances = [float('inf')] * n
    distances[source] = 0
    
    while pq:
        d, u = heapq.heappop(pq)
        
        if d > distances[u]:
            continue
            
        for v, weight in adj[u]:
            if distances[u] + weight < distances[v]:
                distances[v] = distances[u] + weight
                heapq.heappush(pq, (distances[v], v))
    
    max_time = max(distances)
    
    if max_time == float('inf'):
        print("-1")
    else:
        print(max_time)

func()