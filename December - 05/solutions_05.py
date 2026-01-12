def dfs(grid,r,c,R,C):
  if(r < 0 or c < 0 or r >= R or c >= C or grid[r][c] == 0):
    return

  dfs(grid,r+1,c,R,C)
  dfs(grid,r-1,c,R,C)
  dfs(grid,r,c+1,R,C)
  dfs(grid,r,c-1,R,C)

R = int(input("Enter the number of rows: "))
C = int(input("Enter the number of columns: "))
grid = []
for i in range(R):
  row = []
  for j in range(C):
    v = int(input("Enter the value: "))
    row.append(v)
  grid.append(row)

islands = 0

for r in range(R):
  for c in range(C):
    if grid[r][c] == 1:
      islands += 1
      dfs(grid,r,c,R,C)
      
print(islands) 
