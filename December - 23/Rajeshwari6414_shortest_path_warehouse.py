from collections import deque

m, n = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(m)]

if grid[0][0] == 1 or grid[m-1][n-1] == 1:
    print(-1)
else:
    queue = deque([(0, 0, 0)])
    visited = [[False]*n for _ in range(m)]
    visited[0][0] = True
    directions = [(1,0),(-1,0),(0,1),(0,-1)]

    while queue:
        x, y, d = queue.popleft()
        if x == m-1 and y == n-1:
            print(d)
            break
        for dx, dy in directions:
            nx, ny = x+dx, y+dy
            if 0 <= nx < m and 0 <= ny < n and not visited[nx][ny] and grid[nx][ny] == 0:
                visited[nx][ny] = True
                queue.append((nx, ny, d+1))
    else:
        print(-1)
