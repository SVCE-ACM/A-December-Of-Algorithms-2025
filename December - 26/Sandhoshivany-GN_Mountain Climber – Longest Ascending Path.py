import sys
sys.setrecursionlimit(100000)

def longest_increasing_path(matrix):
    if not matrix or not matrix[0]:
        return 0

    M, N = len(matrix), len(matrix[0])
    dp = [[0] * N for _ in range(M)]  
    directions = [(-1,0), (1,0), (0,-1), (0,1)]

    def dfs(i, j):
        if dp[i][j] != 0:
            return dp[i][j]

        max_len = 1  
        for dx, dy in directions:
            x, y = i + dx, j + dy
            if 0 <= x < M and 0 <= y < N and matrix[x][y] > matrix[i][j]:
                max_len = max(max_len, 1 + dfs(x, y))

        dp[i][j] = max_len
        return dp[i][j]

    
    ans = 0
    for i in range(M):
        for j in range(N):
            ans = max(ans, dfs(i, j))

    return ans



M, N = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(M)]
print(longest_increasing_path(matrix))
