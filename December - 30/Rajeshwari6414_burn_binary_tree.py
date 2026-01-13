from collections import defaultdict, deque

edges = eval(input())
target = int(input())

graph = defaultdict(list)
for u, v in edges:
    graph[u].append(v)
    graph[v].append(u)

visited = set([target])
queue = deque([target])

while queue:
    level = list(queue)
    print(", ".join(map(str, level)))
    for _ in range(len(queue)):
        u = queue.popleft()
        for v in graph[u]:
            if v not in visited:
                visited.add(v)
                queue.append(v)
