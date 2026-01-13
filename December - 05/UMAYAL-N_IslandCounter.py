def dfs(grid, r, c):
    if r < 0 or c < 0 or r >= rows or c >= cols or grid[r][c] == 0:
        return
    grid[r][c] = 0
    dfs(grid, r+1, c)
    dfs(grid, r-1, c)
    dfs(grid, r, c+1)
    dfs(grid, r, c-1)


rows, cols = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(rows)]

count = 0
for i in range(rows):
    for j in range(cols):
        if grid[i][j] == 1:
            dfs(grid, i, j)
            count += 1

print(count)
