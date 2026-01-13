# December 30 - Burn the Binary Tree from Target Node
from collections import defaultdict, deque

# Number of connections
E = int(input().strip())

adj = defaultdict(list)

# Build undirected connections (tree edges)
for _ in range(E):
    u, v = map(int, input().split())
    adj[u].append(v)
    adj[v].append(u)

# Read target node
target = int(input().strip())

# BFS from target
q = deque([target])
visited = {target}

while q:
    level_nodes = []

    for _ in range(len(q)):
        node = q.popleft()
        level_nodes.append(node)

        for nei in adj[node]:
            if nei not in visited:
                visited.add(nei)
                q.append(nei)

    # Print nodes burning at this time step
    print(*level_nodes, sep=", ")
