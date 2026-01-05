import sys

def solve():
    data = list(map(int, sys.stdin.read().strip().split()))
    if not data:
        return
    it = iter(data)
    V = next(it)
    edges = list(zip(it, it, it))  # u,v,w
    INF = 10**18
    dist = [[INF] * V for _ in range(V)]
    for i in range(V):
        dist[i][i] = 0
    for u, v, w in edges:
        dist[u][v] = min(dist[u][v], w)
        dist[v][u] = min(dist[v][u], w)
    ans = INF
    # Floyd-Warshall with cycle tracking
    for k in range(V):
        for i in range(k):
            for j in range(i + 1, k):
                if dist[i][j] < INF and dist[i][k] < INF and dist[k][j] < INF:
                    ans = min(ans, dist[i][j] + dist[i][k] + dist[k][j])
        for i in range(V):
            for j in range(V):
                if dist[i][k] + dist[k][j] < dist[i][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]
    print(ans if ans < INF else -1)

if __name__ == "__main__":
    solve()
