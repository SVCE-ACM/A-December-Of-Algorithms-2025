R,C  =map(int,input("enter number of rows and columns:").split())
grid=[]
for _ in range(R):
      grid.append(list(map(int,input(
          
      ).split())))
def dfs(i,j):
    if (i<0 or i>=R or  j<0 or j>=C):
      return
    if grid[i][j]==0:
      return

    grid[i][j]=0      

    dfs(i+1,j)
    dfs(i-1,j)
    dfs(i,j+1) 
    dfs(i,j-1)

island=0
for i in range(R):
    for j in range(C):
         if grid[i][j]==1:
            island+=1
            dfs(i,j)
print(island)

enter number of rows and columns:4 5
1 1 0 0 0
1 1 0 0 1
0 0 0 1 1
0 0 0 0 0 
2