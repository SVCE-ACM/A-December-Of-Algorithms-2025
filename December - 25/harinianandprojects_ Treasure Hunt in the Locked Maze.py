from collections import deque
M, N = map(int, input().split())
maze = []
for _ in range(M):
    maze.append(list(input()))
for i in range(M):
    for j in range(N):
        if maze[i][j] == 'S':
            start_row = i
            start_col = j
q = deque()
q.append((start_row, start_col, set(), 0))
visited = set()
visited.add((start_row, start_col, frozenset()))
moves = [(1,0), (-1,0), (0,1), (0,-1)]
answer = -1
while q:
    r, c, keys, steps = q.popleft()
    if maze[r][c] == 'T':
        answer = steps
        break
    for dr, dc in moves:
        nr = r + dr
        nc = c + dc

        if 0 <= nr < M and 0 <= nc < N:
            cell = maze[nr][nc]

            
            if cell == '#':
                continue

            new_keys = set(keys)

            
            if 'a' <= cell <= 'j':
                new_keys.add(cell)

            
            if 'A' <= cell <= 'J':
                if cell.lower() not in keys:
                    continue

            state = (nr, nc, frozenset(new_keys))
            if state not in visited:
                visited.add(state)
                q.append((nr, nc, new_keys, steps + 1))

print(answer)
