import sys
sys.setrecursionlimit(10**6)

def longestIncreasingPath(matrix, M, N):
    directions = [(-1,0),(1,0),(0,-1),(0,1)]
    memo = [[0]*N for _ in range(M)]
    
    def dfs(r, c):
        if memo[r][c] != 0:
            return memo[r][c]
        max_len = 1 
        for dr, dc in directions:
            nr, nc = r+dr, c+dc
            if 0 <= nr < M and 0 <= nc < N and matrix[nr][nc] > matrix[r][c]:
                max_len = max(max_len, 1 + dfs(nr, nc))
        
        memo[r][c] = max_len
        return max_len
    
    ans = 0
    for i in range(M):
        for j in range(N):
            ans = max(ans, dfs(i, j))
    
    return ans
if __name__ == "__main__":
    M, N = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(M)]
    result = longestIncreasingPath(matrix, M, N)
    print(result)
