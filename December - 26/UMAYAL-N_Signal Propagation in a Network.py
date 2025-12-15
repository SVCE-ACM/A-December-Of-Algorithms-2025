# December 26 - Longest Ascending Path in Terrain (DFS + Memoization)

import sys
sys.setrecursionlimit(10**7)

# Read dimensions
M, N = map(int, input().split())

# Read grid
grid = [list(map(int, input().split())) for _ in range(M)]

# Memo table to store longest path starting at each cell
memo = [[0] * N for _ in range(M)]

# Directions (up, down, left, right)
dirs = [(1,0), (-1,0), (0,1), (0,-1)]

# DFS to find longest increasing path
def dfs(r, c):
    if memo[r][c] != 0:
        return memo[r][c]

    best = 1  # minimum path length = 1 (the cell itself)

    for dr, dc in dirs:
        nr, nc = r + dr, c + dc
        if 0 <= nr < M and 0 <= nc < N:
            if grid[nr][nc] > grid[r][c]:   # strictly increasing
                best = max(best, 1 + dfs(nr, nc))

    memo[r][c] = best
    return best

# Find best among all cells
ans = 0
for i in range(M):
    for j in range(N):
        ans = max(ans, dfs(i, j))

print(ans)
