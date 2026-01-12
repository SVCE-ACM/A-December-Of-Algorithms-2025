import sys
sys.setrecursionlimit(10**7)

M, N = map(int, input().split())
mat = [list(map(int, input().split())) for _ in range(M)]
dp = [[0]*N for _ in range(M)]
def dfs(r, c):
    if dp[r][c]:
        return dp[r][c]
    best = 1
    for dr, dc in [(1,0), (-1,0), (0,1), (0,-1)]:
        nr, nc = r + dr, c + dc
        if 0 <= nr < M and 0 <= nc < N and mat[nr][nc] > mat[r][c]:
            best = max(best, 1 + dfs(nr, nc))
    dp[r][c] = best
    return best
ans = 0
for i in range(M):
    for j in range(N):
        ans = max(ans, dfs(i, j))
print(ans)