def dfs(grid, r, c, R, C):
   
    if r < 0 or r >= R or c < 0 or c >= C or grid[r][c] == 0:
        return
    
    grid[r][c] = 0
    
    dfs(grid, r+1, c, R, C)
    dfs(grid, r-1, c, R, C)
    dfs(grid, r, c+1, R, C)
    dfs(grid, r, c-1, R, C)

def countIslands(grid, R, C):
    count = 0
    for i in range(R):
        for j in range(C):
            if grid[i][j] == 1:
                dfs(grid, i, j, R, C)
                count += 1
    return count


R, C = map(int, input().split())
grid = []
for _ in range(R):
    grid.append(list(map(int, input().split())))

print(countIslands(grid, R, C))