m, n = map(int, input().split())
grid = []
for _ in range(m):
    grid.append(list(map(int, input().split())))
dp = [[0] * n for _ in range(m)]
dirs = [(1,0), (-1,0), (0,1), (0,-1)]
def dfs(x, y):
    if dp[x][y] != 0:
        return dp[x][y]
    best = 1  
    for dx, dy in dirs:
        nx = x + dx
        ny = y + dy
        if 0 <= nx < m and 0 <= ny < n:
            if grid[nx][ny] > grid[x][y]:
                best = max(best, 1 + dfs(nx, ny))
    dp[x][y] = best
    return best
ans = 1
for i in range(m):
    for j in range(n):
        ans = max(ans, dfs(i, j))
print(ans)