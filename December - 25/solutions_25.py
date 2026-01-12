def find_treasure(M, N, maze):
    start = None
    for i in range(M):
        for j in range(N):
            if maze[i][j] == 'S':
                start = (i, j)
                break
        if start:
            break
    
    q = [(start[0], start[1], 0, frozenset())]
    visited = set()
    visited.add((start[0], start[1], frozenset()))
    
    moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    
    while q:
        r, c, steps, keys = q.pop(0)
        
        if maze[r][c] == 'T':
            return steps
        
        for dr, dc in moves:
            nr, nc = r + dr, c + dc
            
            if 0 <= nr < M and 0 <= nc < N:
                cell = maze[nr][nc]
                
                if cell == '#':
                    continue
                
                if cell >= 'A' and cell <= 'J':
                    if cell.lower() not in keys:
                        continue
                
                new_keys = keys
                if cell >= 'a' and cell <= 'j':
                    new_keys = keys | {cell}
                
                state = (nr, nc, new_keys)
                if state not in visited:
                    visited.add(state)
                    q.append((nr, nc, steps + 1, new_keys))
    
    return -1

M, N = map(int, input("Enter rows and columns: ").split())
maze = []
print("Enter the maze:")
for _ in range(M):
    row = input().strip()
    maze.append(row)

result = find_treasure(M, N, maze)
print(result)
