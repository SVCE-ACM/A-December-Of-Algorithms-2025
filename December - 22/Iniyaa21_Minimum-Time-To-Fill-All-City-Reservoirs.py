from collections import deque

v,e = [int(i) for i in input().split()]

adj = [[] for _ in range(v)]
for _ in range(e):
    u, v_node = map(int, input().split())
    adj[u].append(v_node)
    adj[v_node].append(u)
    
states = [int(i) for i in input().split()]

queue = deque()
visited = [-1] * v
filled_count = 0

for i in range(v):
    if states[i] == 1:
        queue.append(i)
        visited[i] = 0
        filled_count += 1
        
max_time = 0

while queue:
    curr = queue.popleft()
    max_time = max(max_time, visited[curr])
    
    for neighbor in adj[curr]:
        if visited[neighbor] == -1:
            visited[neighbor] = visited[curr] + 1
            filled_count += 1
            queue.append(neighbor)
            
if filled_count < v:
    print("-1")
else:
    print(max_time)

