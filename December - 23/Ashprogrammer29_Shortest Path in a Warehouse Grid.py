from collections import deque

def shortest_path_warehouse(grid):
    m, n = len(grid), len(grid[0])
    
    if grid[0][0] == 1 or grid[m-1][n-1] == 1:
        return -1  # Start or goal blocked
    
    queue = deque([(0, 0, 0)])  # (row, col, steps)
    visited = [[False]*n for _ in range(m)]
    visited[0][0] = True
    
    directions = [(-1,0), (1,0), (0,-1), (0,1)]
    
    while queue:
        r, c, steps = queue.popleft()
        
        if r == m-1 and c == n-1:
            return steps
        
        for dr, dc in directions:
            nr, nc = r + dr, c + dc
            if 0 <= nr < m and 0 <= nc < n and not visited[nr][nc] and grid[nr][nc] == 0:
                visited[nr][nc] = True
                queue.append((nr, nc, steps + 1))
    
    return -1

# Read input
m, n = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(m)]

print(shortest_path_warehouse(grid))
