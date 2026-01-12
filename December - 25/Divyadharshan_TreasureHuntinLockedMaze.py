from collections import deque
M, N = map(int, input().split())
maze = [list(input().strip()) for _ in range(M)]
for i in range(M):
    for j in range(N):
        if maze[i][j] == 'S':
            sr, sc = i, j
q = deque([(sr, sc, 0, 0)])
visited = set([(sr, sc, 0)])
while q:
    r, c, keys, steps = q.popleft()
    if maze[r][c] == 'T':
        print(steps)
        exit()
    for dr, dc in [(1,0), (-1,0), (0,1), (0,-1)]:
        nr, nc = r + dr, c + dc
        if 0 <= nr < M and 0 <= nc < N:
            cell = maze[nr][nc]
            new_keys = keys
            if cell == '#':
                continue
            if 'a' <= cell <= 'j':
                new_keys |= 1 << (ord(cell) - ord('a'))
            if 'A' <= cell <= 'J':
                if not (keys & (1 << (ord(cell) - ord('A')))):
                    continue
            state = (nr, nc, new_keys)
            if state not in visited:
                visited.add(state)
                q.append((nr, nc, new_keys, steps + 1))
print(-1)