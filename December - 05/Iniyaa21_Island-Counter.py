rows, cols = [int(i) for i in input().split()] 
grid = [] 
islands = 0 

for _ in range(rows):
    grid.append([int(i) for i in input().split()])

def dfs(r,c): 
    grid[r][c] = 0 
    directions = [(r-1,c), (r+1,c), (r,c-1), (r,c+1)]
    for row, col in directions:
        if row >= 0 and col >= 0 and row < rows and col < cols and grid[row][col] == 1:
            dfs(row, col)

for r in range(rows):
    for c in range(cols):
        if grid[r][c] == 1:
            dfs(r,c) 
            islands += 1

print(islands)