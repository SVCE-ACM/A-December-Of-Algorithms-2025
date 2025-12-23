from collections import deque

v, e = map(int, input().split())

g = [[] for _ in range(v)]
for _ in range(e):
    a, b = map(int, input().split())
    g[a].append(b)
    g[b].append(a)

arr = list(map(int, input().split()))

q = deque()
t = [-1] * v

for i in range(v):
    if arr[i] == 1:
        q.append(i)
        t[i] = 0

while q:
    x = q.popleft()
    for y in g[x]:
        if t[y] == -1:
            t[y] = t[x] + 1
            q.append(y)

ans = 0
for i in range(v):
    if t[i] == -1:
        print(-1)
        exit()
    ans = max(ans, t[i])

print(ans)

