# input terrain dimensions
M, N = map(int, input("Enter rows and columns: ").split())

# input the terrain heights
matrix = [list(map(int, input().split())) for _ in range(M)]

# directions: up, down, left, right
dirs = [(-1,0),(1,0),(0,-1),(0,1)]

# memoization table
dp = [[0]*N for _ in range(M)]

def dfs(r, c):
    if dp[r][c] != 0:
        return dp[r][c]
    max_len = 1
    for dr, dc in dirs:
        nr, nc = r+dr, c+dc
        if 0<=nr<M and 0<=nc<N and matrix[nr][nc] > matrix[r][c]:
            max_len = max(max_len, 1 + dfs(nr, nc))
    dp[r][c] = max_len
    return max_len

res = 0
for i in range(M):
    for j in range(N):
        res = max(res, dfs(i,j))

print(res)
