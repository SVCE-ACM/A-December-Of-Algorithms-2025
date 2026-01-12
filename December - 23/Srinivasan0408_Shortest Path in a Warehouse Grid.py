def shortest_path_in_warehouse(m, n, grid):
    if grid[0][0] == 1 or grid[m-1][n-1] == 1:
        return -1
    
    directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
   
    queue = [(0, 0, 0)] 
    visited = set((0, 0))
    
    while queue:
        row, col, steps = queue.pop(0) 
        
        if row == m-1 and col == n-1:
            return steps
        
        for dr, dc in directions:
            new_row, new_col = row + dr, col + dc
            
            if (0 <= new_row < m and 0 <= new_col < n and 
                grid[new_row][new_col] == 0 and 
                (new_row, new_col) not in visited):
                
                visited.add((new_row, new_col))
                queue.append((new_row, new_col, steps + 1))  
    
    return -1
m, n = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(m)]
print(shortest_path_in_warehouse(m, n, grid))
