from collections import deque

def min_steps_to_treasure(maze, M, N):
    
    directions = [(-1,0), (1,0), (0,-1), (0,1)]

    
    for i in range(M):
        for j in range(N):
            if maze[i][j] == 'S':
                start = (i, j)
    
    
    q = deque([(start[0], start[1], 0, 0)])
    visited = set([(start[0], start[1], 0)])  

    while q:
        x, y, keys, steps = q.popleft()

        
        if maze[x][y] == 'T':
            return steps

        for dx, dy in directions:
            nx, ny = x + dx, y + dy

            if 0 <= nx < M and 0 <= ny < N:
                cell = maze[nx][ny]
                new_keys = keys

                if cell == '#':
                    continue 

           
                if 'a' <= cell <= 'j':
                    new_keys |= (1 << (ord(cell) - ord('a')))

               
                if 'A' <= cell <= 'J':
                    if not (keys & (1 << (ord(cell) - ord('A')))):
                        continue 

                
                state = (nx, ny, new_keys)
                if state not in visited:
                    visited.add(state)
                    q.append((nx, ny, new_keys, steps + 1))

    return -1



M, N = map(int, input().split())
maze = [list(input().strip()) for _ in range(M)]
print(min_steps_to_treasure(maze, M, N))
