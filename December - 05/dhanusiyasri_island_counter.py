def count_islands(grid, R, C):
    visited = [[False] * C for _ in range(R)]

    def dfs(r, c):
        # Boundary and visited checks
        if r < 0 or r >= R or c < 0 or c >= C:
            return
        if grid[r][c] == 0 or visited[r][c]:
            return
        # Mark current cell as visited
        visited[r][c] = True
        # Explore neighbors (up, down, left, right)
        dfs(r+1, c)
        dfs(r-1, c)
        dfs(r, c+1)
        dfs(r, c-1)

    islands = 0
    for r in range(R):
        for c in range(C):
            if grid[r][c] == 1 and not visited[r][c]:
                dfs(r, c)
                islands += 1
    return islands


# Input reading
R, C = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(R)]

print(count_islands(grid, R, C))