import sys
sys.setrecursionlimit(10**7)

m, n = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(m)]
dp = [[0]*n for _ in range(m)]
dirs = [(1,0),(-1,0),(0,1),(0,-1)]

def dfs(x, y):
    if dp[x][y]:
        return dp[x][y]
    best = 1
    for dx, dy in dirs:
        nx, ny = x+dx, y+dy
        if 0 <= nx < m and 0 <= ny < n and grid[nx][ny] > grid[x][y]:
            best = max(best, 1 + dfs(nx, ny))
    dp[x][y] = best
    return best

print(max(dfs(i, j) for i in range(m) for j in range(n)))
