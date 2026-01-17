m, n = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(m)]

dp = [[0]*n for _ in range(m)]
dirs = [(1,0),(-1,0),(0,1),(0,-1)]

def go(i, j):
    if dp[i][j]:
        return dp[i][j]
    best = 1
    for x, y in dirs:
        ni, nj = i+x, j+y
        if 0 <= ni < m and 0 <= nj < n and a[ni][nj] > a[i][j]:
            best = max(best, 1 + go(ni, nj))
    dp[i][j] = best
    return best

ans = 0
for i in range(m):
    for j in range(n):
        ans = max(ans, go(i, j))

print(ans)
