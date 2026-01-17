import sys
from collections import deque

def solve():
    data = sys.stdin.read().strip().split()
    if len(data) < 2:
        return
    r, c = int(data[0]), int(data[1])
    vals = list(map(int, data[2:2 + r * c]))
    grid = [vals[i * c:(i + 1) * c] for i in range(r)]
    visited = [[False]*c for _ in range(r)]
    dirs = [(1,0),(-1,0),(0,1),(0,-1)]
    count = 0
    for i in range(r):
        for j in range(c):
            if grid[i][j] == 1 and not visited[i][j]:
                count += 1
                dq = deque([(i,j)])
                visited[i][j] = True
                while dq:
                    x,y = dq.popleft()
                    for dx,dy in dirs:
                        nx, ny = x+dx, y+dy
                        if 0<=nx<r and 0<=ny<c and not visited[nx][ny] and grid[nx][ny]==1:
                            visited[nx][ny]=True
                            dq.append((nx,ny))
    print(count)

if __name__ == "__main__":
    solve()
