from collections import deque

def shortest_path_in_warehouse(grid):
    m, n = len(grid), len(grid[0])
    
    
    if grid[0][0] == 1 or grid[m-1][n-1] == 1:
        return -1


    directions = [(-1,0), (1,0), (0,-1), (0,1)]

    q = deque([(0, 0, 0)])  
    visited = [[False]*n for _ in range(m)]
    visited[0][0] = True

    while q:
        x, y, steps = q.popleft()

       
        if x == m-1 and y == n-1:
            return steps

        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            if 0 <= nx < m and 0 <= ny < n and not visited[nx][ny] and grid[nx][ny] == 0:
                visited[nx][ny] = True
                q.append((nx, ny, steps + 1))

    return -1

m, n = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(m)]
print(shortest_path_in_warehouse(grid))
