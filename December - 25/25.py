from collections import deque

def min_steps_maze_with_keys(maze, M, N):
    start = None
    for i in range(M):
        for j in range(N):
            if maze[i][j] == 'S':
                start = (i, j)
                break
    directions = [(-1,0),(1,0),(0,-1),(0,1)]
    q = deque([(start[0], start[1], 0, 0)])
    visited = set([(start[0], start[1], 0)])
    
    while q:
        r, c, keys, steps = q.popleft()
        if maze[r][c] == 'T':
            return steps
        for dr, dc in directions:
            nr, nc = r+dr, c+dc
            if 0 <= nr < M and 0 <= nc < N:
                cell = maze[nr][nc]
                
                if cell == '#': 
                    continue
                
                new_keys = keys
                if 'a' <= cell <= 'j':  
                    new_keys |= (1 << (ord(cell) - ord('a')))
                if 'A' <= cell <= 'J': 
                    if not (new_keys & (1 << (ord(cell) - ord('A')))):
                        continue
                state = (nr, nc, new_keys)
                if state not in visited:
                    visited.add(state)
                    q.append((nr, nc, new_keys, steps+1))
    
    return -1
if __name__ == "__main__":
    M, N = map(int, input().split())
    maze = [list(input().strip()) for _ in range(M)]
    result = min_steps_maze_with_keys(maze, M, N)
    print(result)
