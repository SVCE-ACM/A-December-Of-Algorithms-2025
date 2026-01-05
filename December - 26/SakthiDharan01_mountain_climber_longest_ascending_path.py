import sys
sys.setrecursionlimit(1_000_000)

def solve():
    data = list(map(int, sys.stdin.read().strip().split()))
    if len(data) < 2:
        return
    m, n = data[0], data[1]
    vals = data[2:2+m*n]
    grid = [vals[i*n:(i+1)*n] for i in range(m)]
    memo = [[0]*n for _ in range(m)]
    dirs = [(1,0),(-1,0),(0,1),(0,-1)]

    def dfs(x, y):
        if memo[x][y]:
            return memo[x][y]
        best = 1
        for dx, dy in dirs:
            nx, ny = x+dx, y+dy
            if 0<=nx<m and 0<=ny<n and grid[nx][ny] > grid[x][y]:
                best = max(best, 1 + dfs(nx, ny))
        memo[x][y] = best
        return best

    ans = 0
    for i in range(m):
        for j in range(n):
            ans = max(ans, dfs(i, j))
    print(ans)

if __name__ == "__main__":
    solve()
