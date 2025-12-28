from collections import deque
def shortestPath(grid):
    m, n = len(grid), len(grid[0])
    if grid[0][0] == 1 or grid[m-1][n-1] == 1:
        return -1
    q = deque([(0, 0, 0)])
    visited = [[False]*n for _ in range(m)]
    visited[0][0] = True
    while q:
        r, c, steps = q.popleft()
        if r == m-1 and c == n-1:
            return steps
        for dr, dc in [(1,0), (-1,0), (0,1), (0,-1)]:
            nr, nc = r + dr, c + dc
            if 0 <= nr < m and 0 <= nc < n:
                if grid[nr][nc] == 0 and not visited[nr][nc]:
                    visited[nr][nc] = True
                    q.append((nr, nc, steps + 1))

    return -1
m, n = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(m)]
print(shortestPath(grid))