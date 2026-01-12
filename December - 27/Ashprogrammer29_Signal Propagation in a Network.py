import heapq
import sys
input = sys.stdin.readline

def solve():
    N = int(input().strip())
    M = int(input().strip())

    graph = [[] for _ in range(N)]

    for _ in range(M):
        u, v, t = map(int, input().split())
        graph[u].append((v, t))   

    S = int(input().strip())

    dist = [float('inf')] * N
    dist[S] = 0

    pq = [(0, S)]  

    while pq:
        time, node = heapq.heappop(pq)

        if time > dist[node]:
            continue

        for nei, w in graph[node]:
            new_time = time + w
            if new_time < dist[nei]:
                dist[nei] = new_time
                heapq.heappush(pq, (new_time, nei))

    
    max_time = max(dist)
    if max_time == float('inf'):
        print(-1)
    else:
        print(max_time)



solve()
