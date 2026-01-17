from collections import deque

def min_minutes_to_fill(V, edges, initial):
    graph = [[] for _ in range(V)]
    for u, v in edges:
        graph[u].append(v)
        graph[v].append(u)
    q = deque()
    visited = [False] * V
    for i in range(V):
        if initial[i] == 1:
            q.append((i, 0))
            visited[i] = True
    
    max_time = 0
    while q:
        node, time = q.popleft()
        max_time = max(max_time, time)
        
        for nei in graph[node]:
            if not visited[nei]:
                visited[nei] = True
                q.append((nei, time + 1))
    if all(visited):
        return max_time
    else:
        return -1
if __name__ == "__main__":
    V, E = map(int, input().split())
    edges = [tuple(map(int, input().split())) for _ in range(E)]
    initial = list(map(int, input().split()))
    result = min_minutes_to_fill(V, edges, initial)
    print(result)
