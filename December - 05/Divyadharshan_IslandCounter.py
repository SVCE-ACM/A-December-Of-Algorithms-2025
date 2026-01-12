r,c=[int(i) for i in input().split()]
arr=[]

for i in range(r):
    arr.append([int(i) for i in input().split()])

def dfs(i,j):
    if i>=0 and i<r and j>=0 and j<c and arr[i][j]==1:
        arr[i][j]=0
        dfs(i+1,j)
        dfs(i-1,j)
        dfs(i,j+1)
        dfs(i,j-1)
    else:
        return 1
    
ans=0
for i in range(r):
    for j in range(c):
        if arr[i][j]==1:
            dfs(i,j)
            ans+=1
print(ans)