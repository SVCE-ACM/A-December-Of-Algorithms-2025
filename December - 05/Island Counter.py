rows, cols = map(int, input().split())

grid = []
for _ in range(rows):
    grid.append(list(map(int, input().split())))

def dfs(r, c):
    if r < 0 or r >= rows or c < 0 or c >= cols:
        return
    if grid[r][c] == 0:
        return

    grid[r][c] = 0  

    dfs(r + 1, c)
    dfs(r - 1, c)
    dfs(r, c + 1)
    dfs(r, c - 1)

count = 0
for i in range(rows):
    for j in range(cols):
        if grid[i][j] == 1:
            count += 1
            dfs(i, j)

print(count)
