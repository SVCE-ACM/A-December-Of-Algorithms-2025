# December 25 - Treasure Hunt in the Locked Maze

from collections import deque

M, N = map(int, input().split())
grid = [list(input().strip()) for _ in range(M)]

start = None
for i in range(M):
    for j in range(N):
        if grid[i][j] == 'S':
            start = (i, j)

# BFS: (row, col, keymask)
q = deque([(start[0], start[1], 0, 0)])  # r, c, keys, steps
visited = set([(start[0], start[1], 0)])

dirs = [(1,0), (-1,0), (0,1), (0,-1)]

while q:
    r, c, keys, steps = q.popleft()

    if grid[r][c] == 'T':
        print(steps)
        break

    for dr, dc in dirs:
        nr, nc = r + dr, c + dc
        if 0 <= nr < M and 0 <= nc < N:
            ch = grid[nr][nc]

            if ch == '#':
                continue

            newKeys = keys

            if 'a' <= ch <= 'j':      # pick key
                newKeys |= (1 << (ord(ch) - ord('a')))

            if 'A' <= ch <= 'J':      # need key
                if not (keys & (1 << (ord(ch) - ord('A')))):
                    continue

            state = (nr, nc, newKeys)
            if state not in visited:
                visited.add(state)
                q.append((nr, nc, newKeys, steps + 1))
else:
    print(-1)
