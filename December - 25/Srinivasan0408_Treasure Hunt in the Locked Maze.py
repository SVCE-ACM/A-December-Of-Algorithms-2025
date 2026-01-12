M, N = map(int, input().split())
grid = []
for _ in range(M):
    grid.append(list(input().strip()))

start_x = start_y = -1
for i in range(M):
    for j in range(N):
        if grid[i][j] == 'S':
            start_x, start_y = i, j

visited = [[[False] * 1024 for _ in range(N)] for __ in range(M)]

queue = [(start_x, start_y, 0, 0)]
front = 0
visited[start_x][start_y][0] = True

dirs = [(1,0), (-1,0), (0,1), (0,-1)]

def is_key(c):
    return 'a' <= c <= 'j'

def is_door(c):
    return 'A' <= c <= 'J'

while front < len(queue):
    x, y, mask, dist = queue[front]
    front += 1

    if grid[x][y] == 'T':
        print(dist)
        break

    for dx, dy in dirs:
        nx = x + dx
        ny = y + dy

        if 0 <= nx < M and 0 <= ny < N:
            cell = grid[nx][ny]

            if cell == '#':
                continue

            new_mask = mask

            if is_key(cell):
                new_mask = mask | (1 << (ord(cell) - ord('a')))

            if is_door(cell):
                door_bit = ord(cell) - ord('A')
                if not (mask & (1 << door_bit)):
                    continue  

            if not visited[nx][ny][new_mask]:
                visited[nx][ny][new_mask] = True
                queue.append((nx, ny, new_mask, dist + 1))
else:
    print(-1)