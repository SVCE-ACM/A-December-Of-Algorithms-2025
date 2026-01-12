def count_islands(grid, R, C):
    def dfs(r, c):
        if r < 0 or r >= R or c < 0 or c >= C or grid[r][c] == 0:
            return
        grid[r][c] = 0  
        dfs(r+1, c)
        dfs(r-1, c)
        dfs(r, c+1)
        dfs(r, c-1)

    islands = 0

    for r in range(R):
        for c in range(C):
            if grid[r][c] == 1:
                islands += 1
                dfs(r, c)

    return islands
