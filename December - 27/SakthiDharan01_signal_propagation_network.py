import sys
import heapq

def solve():
    data = list(map(int, sys.stdin.read().strip().split()))
    if len(data) < 3:
        return
    it = iter(data)
    n = next(it)
    m = next(it)
    adj = [[] for _ in range(n)]
    for _ in range(m):
        try:
            u = next(it)
            v = next(it)
            w = next(it)
        except StopIteration:
            return
        adj[u].append((v, w))
    source = next(it, 0)
    dist = [float('inf')] * n
    dist[source] = 0
    pq = [(0, source)]
    while pq:
        d, u = heapq.heappop(pq)
        if d != dist[u]:
            continue
        for v, w in adj[u]:
            nd = d + w
            if nd < dist[v]:
                dist[v] = nd
                heapq.heappush(pq, (nd, v))
    if any(d == float('inf') for d in dist):
        print(-1)
    else:
        print(int(max(dist)))

if __name__ == "__main__":
    solve()
