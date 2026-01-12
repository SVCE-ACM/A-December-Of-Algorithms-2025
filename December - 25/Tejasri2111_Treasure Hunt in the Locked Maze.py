from collections import deque

# input maze dimensions
M, N = map(int, input("Enter rows and columns: ").split())

# input the maze
maze = [list(input(f"Row {i+1}: ")) for i in range(M)]

# find start position
for i in range(M):
    for j in range(N):
        if maze[i][j] == 'S':
            start = (i, j)

# BFS: (row, col, steps, keys_bitmask)
q = deque()
q.append((start[0], start[1], 0, 0))
visited = set()
visited.add((start[0], start[1], 0))

dirs = [(-1,0),(1,0),(0,-1),(0,1)]

while q:
    r, c, steps, keys = q.popleft()
    cell = maze[r][c]
    
    # collect key
    if 'a' <= cell <= 'j':
        keys |= (1 << (ord(cell) - ord('a')))
    
    # reached treasure
    if cell == 'T':
        print(steps)
        break
    
    # explore neighbors
    for dr, dc in dirs:
        nr, nc = r+dr, c+dc
        if 0<=nr<M and 0<=nc<N:
            ncell = maze[nr][nc]
            
            # wall
            if ncell == '#':
                continue
            
            # door
            if 'A' <= ncell <= 'J' and not (keys & (1 << (ord(ncell)-ord('A')))):
                continue
            
            # check if state visited
            if (nr, nc, keys) not in visited:
                visited.add((nr, nc, keys))
                q.append((nr, nc, steps+1, keys))
else:
    # treasure unreachable
    print(-1)
