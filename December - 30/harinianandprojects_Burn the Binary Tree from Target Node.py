from collections import defaultdict, deque

E = int(input())

adj = defaultdict(list)
for _ in range(E):
    u, v = map(int, input().split())
    adj[u].append(v)
    adj[v].append(u)

target = int(input())

q = deque([target])
visited = set([target])

while q:
    level = []
    for _ in range(len(q)):
        node = q.popleft()
        level.append(node)
        for nei in adj[node]:
            if nei not in visited:
                visited.add(nei)
                q.append(nei)
    print(*level, sep=", ")
