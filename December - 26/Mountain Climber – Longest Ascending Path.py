import sys
sys.setrecursionlimit(10000)

M, N = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(M)]

dp = [[0]*N for _ in range(M)]

dirs = [(-1,0),(1,0),(0,-1),(0,1)]

def dfs(r, c):
    if dp[r][c]:
        return dp[r][c]
    max_len = 1
    for dr, dc in dirs:
        nr, nc = r + dr, c + dc
        if 0 <= nr < M and 0 <= nc < N and matrix[nr][nc] > matrix[r][c]:
            max_len = max(max_len, 1 + dfs(nr, nc))
    dp[r][c] = max_len
    return max_len

ans = 0
for i in range(M):
    for j in range(N):
        ans = max(ans, dfs(i,j))

print(ans)
