from collections import deque

def find_path(matrix, rows, cols):
    
    if matrix[0][0] == 1 or matrix[rows-1][cols-1] == 1:
        return -1
    
    q = deque()
    q.append((0, 0, 0))  
    seen = [[False] * cols for _ in range(rows)]
    seen[0][0] = True
    
    moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    
    while q:
        r, c, count = q.popleft()
        
        if r == rows - 1 and c == cols - 1:
            return count
        
        for dr, dc in moves:
            nr = r + dr
            nc = c + dc
            
            if (0 <= nr < rows and 
                0 <= nc < cols and 
                not seen[nr][nc] and 
                matrix[nr][nc] == 0):
                
                seen[nr][nc] = True
                q.append((nr, nc, count + 1))
    
    return -1
  
rows, cols = map(int, input("Enter rows and columns: ").split())
matrix = []
print("Enter the grid:")
for i in range(rows):
    line = list(map(int, input().split()))
    matrix.append(line)

ans = find_path(matrix, rows, cols)
print(ans)
