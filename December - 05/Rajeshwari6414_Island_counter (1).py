def count_islands(grid, R, C):
    visited = [[False]*C for _ in range(R)]

    def dfs(r, c):
        if r < 0 or r >= R or c < 0 or c >= C:
            return
        if grid[r][c] == 0 or visited[r][c]:
            return

        visited[r][c] = True
        dfs(r+1, c)
        dfs(r-1, c)
        dfs(r, c+1)
        dfs(r, c-1)

    count = 0
    for i in range(R):
        for j in range(C):
            if grid[i][j] == 1 and not visited[i][j]:
                dfs(i, j)
                count += 1
    return count


# Input
R, C = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(R)]

print(count_islands(grid, R, C))
