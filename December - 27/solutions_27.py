def min_signal_time(N, M, links, S):
    graph = [[] for _ in range(N)]
    
    for u, v, t in links:
        graph[u].append((v, t))
    
    dist = [float('inf')] * N
    dist[S] = 0
    
    pq = [(0, S)]
    
    while pq:
        pq.sort()
        curr_time, node = pq.pop(0)
        
        if curr_time > dist[node]:
            continue
        
        for neighbor, time in graph[node]:
            new_time = curr_time + time
            
            if new_time < dist[neighbor]:
                dist[neighbor] = new_time
                pq.append((new_time, neighbor))
    
    max_time = 0
    for i in range(N):
        if dist[i] == float('inf'):
            return -1
        max_time = max(max_time, dist[i])
    
    return max_time

N = int(input("Enter number of towers: "))
M = int(input("Enter number of links: "))
links = []

print("Enter links (u v t):")
for _ in range(M):
    u, v, t = map(int, input().split())
    links.append((u, v, t))

S = int(input("Enter source tower: "))

result = min_signal_time(N, M, links, S)
print(result)
