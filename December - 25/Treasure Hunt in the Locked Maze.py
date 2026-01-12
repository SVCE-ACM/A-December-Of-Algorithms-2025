from collections import deque

M, N = map(int, input().split())
maze = [list(input().strip()) for _ in range(M)]
dirs = [(-1,0),(1,0),(0,-1),(0,1)]


for i in range(M):
    for j in range(N):
        if maze[i][j] == 'S':
            start = (i,j)
            break

queue = deque()
visited = set()


queue.append( (start[0], start[1], 0, 0) )  
visited.add( (start[0], start[1], 0) )

while queue:
    r, c, keys, steps = queue.popleft()
    
    if maze[r][c] == 'T':
        print(steps)
        break
    
    for dr, dc in dirs:
        nr, nc = r + dr, c + dc
        if 0 <= nr < M and 0 <= nc < N:
            cell = maze[nr][nc]
            new_keys = keys
            
            if cell == '#':
                continue
            elif 'a' <= cell <= 'j':
                
                new_keys |= 1 << (ord(cell)-ord('a'))
            elif 'A' <= cell <= 'J':
                
                if not (keys & (1 << (ord(cell)-ord('A')))):
                    continue 
            
            if (nr, nc, new_keys) not in visited:
                visited.add( (nr, nc, new_keys) )
                queue.append( (nr, nc, new_keys, steps+1) )
else:
    print(-1)
