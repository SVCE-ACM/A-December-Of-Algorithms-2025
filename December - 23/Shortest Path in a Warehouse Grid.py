from collections import deque

m, n = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(m)]


dirs = [(-1,0), (1,0), (0,-1), (0,1)]


if grid[0][0] == 1 or grid[m-1][n-1] == 1:
    print(-1)
    exit()

visited = [[False]*n for _ in range(m)]
queue = deque()
queue.append((0,0,0))  
visited[0][0] = True

while queue:
    r, c, steps = queue.popleft()
    if r == m-1 and c == n-1:
        print(steps)
        break
    for dr, dc in dirs:
        nr, nc = r + dr, c + dc
        if 0 <= nr < m and 0 <= nc < n and not visited[nr][nc] and grid[nr][nc] == 0:
            visited[nr][nc] = True
            queue.append((nr, nc, steps + 1))
else:
    print(-1)
