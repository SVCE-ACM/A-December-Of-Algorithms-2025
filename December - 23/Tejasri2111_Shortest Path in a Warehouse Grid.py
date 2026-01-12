from collections import deque

m, n = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(m)]

if grid[0][0] == 1 or grid[m-1][n-1] == 1:
    print(-1)
else:
    q = deque()
    q.append((0, 0, 0))  # (row, col, steps)
    visited = [[False]*n for _ in range(m)]
    visited[0][0] = True
    
    dirs = [(-1,0),(1,0),(0,-1),(0,1)]
    found = False
    
    while q:
        r, c, steps = q.popleft()
        if r == m-1 and c == n-1:
            print(steps)
            found = True
            break
        for dr, dc in dirs:
            nr, nc = r+dr, c+dc
            if 0<=nr<m and 0<=nc<n and not visited[nr][nc] and grid[nr][nc]==0:
                visited[nr][nc] = True
                q.append((nr, nc, steps+1))
    
    if not found:
        print(-1)
