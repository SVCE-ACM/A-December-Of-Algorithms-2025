from collections import deque

m, n = map(int, input().split())

grid = []
for _ in range(m):
    grid.append(list(map(int, input().split())))

if grid[0][0] == 1 or grid[m-1][n-1] == 1:
    print(-1)
    exit()

directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

queue = deque()
queue.append((0, 0))
distance = [[-1] * n for _ in range(m)]
distance[0][0] = 0

while queue:
    x, y = queue.popleft()

    for dx, dy in directions:
        nx, ny = x + dx, y + dy

        if 0 <= nx < m and 0 <= ny < n:
            if grid[nx][ny] == 0 and distance[nx][ny] == -1:
                distance[nx][ny] = distance[x][y] + 1
                queue.append((nx, ny))

ans = distance[m-1][n-1]
print(ans if ans != -1 else -1)
