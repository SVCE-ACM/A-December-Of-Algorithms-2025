from collections import deque

M, N = map(int, input().split())
maze = [list(input().strip()) for _ in range(M)]

for i in range(M):
    for j in range(N):
        if maze[i][j] == 'S':
            start = (i, j)

queue = deque([(start[0], start[1], 0, 0)])
visited = set([(start[0], start[1], 0)])
dirs = [(1,0),(-1,0),(0,1),(0,-1)]

while queue:
    x, y, keys, steps = queue.popleft()
    if maze[x][y] == 'T':
        print(steps)
        break

    for dx, dy in dirs:
        nx, ny = x+dx, y+dy
        if 0 <= nx < M and 0 <= ny < N:
            cell = maze[nx][ny]
            new_keys = keys

            if cell == '#':
                continue
            if 'a' <= cell <= 'j':
                new_keys |= (1 << (ord(cell) - ord('a')))
            if 'A' <= cell <= 'J' and not (keys & (1 << (ord(cell) - ord('A')))):
                continue

            state = (nx, ny, new_keys)
            if state not in visited:
                visited.add(state)
                queue.append((nx, ny, new_keys, steps+1))
else:
    print(-1)
