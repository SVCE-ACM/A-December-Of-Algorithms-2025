def dfs(grid, r, c, R, C):
    if r < 0 or r >= R or c < 0 or c >= C or grid[r][c] == 0:
        return
    grid[r][c] = 0 
    dfs(grid, r+1, c, R, C)
    dfs(grid, r-1, c, R, C)
    dfs(grid, r, c+1, R, C)
    dfs(grid, r, c-1, R, C)
R, C = map(int, input("Enter number of rows and columns (space-separated): ").split())
grid = []
print(f"Enter the land (1) and water (0) representation row by row (space-separated):")
for _ in range(R):
    row = list(map(int, input().split()))
    while len(row) != C:
        print(f"Please enter exactly {C} numbers (0 or 1) for this row:")
        row = list(map(int, input().split()))
    grid.append(row)
count = 0
for i in range(R):
    for j in range(C):
        if grid[i][j] == 1:
            dfs(grid, i, j, R, C)
            count += 1
print(f"Number of islands: {count}")
