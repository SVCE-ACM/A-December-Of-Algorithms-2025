import heapq
from collections import defaultdict

def func():
    V = int(input().split('=')[1].strip())
    
    edges_input = input().strip()
    edges = []
    
    while True:
        line = input().strip()
        if line == ']':
            break
        line = line.strip(' [],')
        if line:
            parts = list(map(int, line.split(',')))
            edges.append(parts)
    
    graph = defaultdict(list)
    for u, v, w in edges:
        graph[u].append((v, w))
        graph[v].append((u, w))
    
    min_cycle = float('inf')
    
    for u, v, edge_weight in edges:
        dist = [float('inf')] * V
        dist[u] = 0
        pq = [(0, u)]
        
        while pq:
            d, node = heapq.heappop(pq)
            
            if d > dist[node]:
                continue
            
            for neighbor, weight in graph[node]:
                if node == u and neighbor == v:
                    continue
                if node == v and neighbor == u:
                    continue
                
                if dist[node] + weight < dist[neighbor]:
                    dist[neighbor] = dist[node] + weight
                    heapq.heappush(pq, (dist[neighbor], neighbor))
        
        if dist[v] != float('inf'):
            cycle_weight = dist[v] + edge_weight
            min_cycle = min(min_cycle, cycle_weight)
    
    print(min_cycle)

func()