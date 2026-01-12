r,c=map(int,input().split())
grid=[input().split() for _ in range(r)]
v=[[False]*c for _ in range(r)]
dir=[(1,0),(-1,0),(0,1),(0,-1)]
def dfs(x,y):
    s=[(x,y)]
    v[x][y]=True
    while s:
        i,j=s.pop()
        for dx,dy in dir:
            ni,nj=i+dx,j+dy
            if 0<=ni<r and 0<=nj<c and grid[ni][nj]=='1' and not v[ni][nj]:
                v[ni][nj]=True
                s.append((ni,nj))
count=0
for i in range(r):
    for j in range(c):
        if grid[i][j]=='1' and not v[i][j]:
            count+=1
            dfs(i,j)
print(count)
      