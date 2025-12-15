# December 22 - AquaNet – Minimum Time to Fill All City Reservoirs
from collections import deque
import sys
input = sys.stdin.readline

# Read number of reservoirs and pipes
V, E = map(int, input().split())

# Build adjacency list
adj = [[] for _ in range(V)]
for _ in range(E):
    u, v = map(int, input().split())
    adj[u].append(v)
    adj[v].append(u)

# Initial water state
state = list(map(int, input().split()))

# Distance array (time for each reservoir to fill)
dist = [-1] * V
q = deque()

# All initially filled reservoirs → push into BFS
for i in range(V):
    if state[i] == 1:
        q.append(i)
        dist[i] = 0

# BFS (multi-source)
while q:
    node = q.popleft()
    for nei in adj[node]:
        if dist[nei] == -1:            # not filled yet
            dist[nei] = dist[node] + 1
            q.append(nei)

# If some reservoir never gets water → unreachable
if -1 in dist:
    print(-1)
else:
    print(max(dist))
