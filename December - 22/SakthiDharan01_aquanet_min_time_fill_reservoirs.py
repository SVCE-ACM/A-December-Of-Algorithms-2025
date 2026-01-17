import sys
from collections import deque

def solve():
    data = list(map(int, sys.stdin.read().strip().split()))
    if len(data) < 2:
        return
    it = iter(data)
    V = next(it)
    E = next(it)
    adj = [[] for _ in range(V)]
    for _ in range(E):
        try:
            u = next(it); v = next(it)
        except StopIteration:
            return
        adj[u].append(v)
        adj[v].append(u)
    initial = [next(it, 0) for _ in range(V)]
    dq = deque()
    dist = [-1]*V
    for i, val in enumerate(initial):
        if val == 1:
            dq.append(i)
            dist[i] = 0
    if not dq:
        print(-1)
        return
    while dq:
        u = dq.popleft()
        for nb in adj[u]:
            if dist[nb] == -1:
                dist[nb] = dist[u] + 1
                dq.append(nb)
    if any(d == -1 for d in dist):
        print(-1)
    else:
        print(max(dist))

if __name__ == "__main__":
    solve()
