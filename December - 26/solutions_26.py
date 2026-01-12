def find_longest_path(M, N, terrain):
    memo = {}
    
    def dfs(r, c):
        if (r, c) in memo:
            return memo[(r, c)]
        
        max_len = 1
        moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        
        for dr, dc in moves:
            nr, nc = r + dr, c + dc
            
            if 0 <= nr < M and 0 <= nc < N:
                if terrain[nr][nc] > terrain[r][c]:
                    max_len = max(max_len, 1 + dfs(nr, nc))
        
        memo[(r, c)] = max_len
        return max_len
    
    result = 0
    for i in range(M):
        for j in range(N):
            result = max(result, dfs(i, j))
    
    return result

M, N = map(int, input("Enter rows and columns: ").split())
terrain = []
print("Enter the terrain heights:")
for _ in range(M):
    row = list(map(int, input().split()))
    terrain.append(row)

result = find_longest_path(M, N, terrain)
print(result)
