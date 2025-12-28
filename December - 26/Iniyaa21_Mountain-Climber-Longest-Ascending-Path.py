def func():
    M, N = [int(i) for i in input().split()]
    
    grid = []
    for _ in range(M):
        grid.append([int(i) for i in input().split()])

    memo = [[0] * N for _ in range(M)]

    def dfs(r, c):
        if memo[r][c] != 0:
            return memo[r][c]
        
        max_len = 1
        for dr, dc in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
            nr, nc = r + dr, c + dc
            if 0 <= nr < M and 0 <= nc < N and grid[nr][nc] > grid[r][c]:
                max_len = max(max_len, 1 + dfs(nr, nc))
        
        memo[r][c] = max_len
        return max_len

    longest_path = 0
    for i in range(M):
        for j in range(N):
            longest_path = max(longest_path, dfs(i, j))
            
    print(longest_path)

func()