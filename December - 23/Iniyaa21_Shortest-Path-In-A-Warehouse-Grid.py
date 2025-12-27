from collections import deque

def find_shortest_path(m, n, grid):
    if grid[0][0] == 1 or grid[m-1][n-1] == 1:
        return -1
    
    queue = deque([(0, 0, 0)]) 
    visited = [[False] * n for _ in range(m)]
    visited[0][0] = True
    
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    
    while queue:
        row, col, steps = queue.popleft()
        
        if row == m - 1 and col == n - 1:
            return steps
        
        for dr, dc in directions:
            new_row, new_col = row + dr, col + dc
            
            if (0 <= new_row < m and 
                0 <= new_col < n and 
                grid[new_row][new_col] == 0 and 
                not visited[new_row][new_col]):
                
                visited[new_row][new_col] = True
                queue.append((new_row, new_col, steps + 1))
    
    return -1

m, n = [int(i) for i in input().split()]
grid = []
for _ in range(m):
    row = [int(i) for i in input().split()]
    grid.append(row)

result = find_shortest_path(m, n, grid)
print(result)