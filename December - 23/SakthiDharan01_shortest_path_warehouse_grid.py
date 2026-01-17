import sys
from collections import deque

def solve():
    data = list(map(int, sys.stdin.read().strip().split()))
    if len(data) < 2:
        return
    m, n = data[0], data[1]
    vals = data[2:2+m*n]
    grid = [vals[i*n:(i+1)*n] for i in range(m)]
    if grid[0][0] == 1 or grid[m-1][n-1] == 1:
        print(-1)
        return
    dist = [[-1]*n for _ in range(m)]
    q = deque([(0,0)])
    dist[0][0] = 0
    dirs = [(1,0),(-1,0),(0,1),(0,-1)]
    while q:
        x,y = q.popleft()
        if (x,y)==(m-1,n-1):
            print(dist[x][y])
            return
        for dx,dy in dirs:
            nx, ny = x+dx, y+dy
            if 0<=nx<m and 0<=ny<n and grid[nx][ny]==0 and dist[nx][ny]==-1:
                dist[nx][ny]=dist[x][y]+1
                q.append((nx,ny))
    print(-1)

if __name__ == "__main__":
    solve()
